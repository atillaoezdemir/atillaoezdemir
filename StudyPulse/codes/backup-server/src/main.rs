use crate::fs::File;
use actix_cors::Cors;
use actix_web::HttpResponse;
use actix_web::{web, App, HttpServer, Result};
use std::fs;
use std::io::Write;
use std::io::{self};

// Save the received JSON data to a file
async fn upload_handler(data: web::Json<serde_json::Value>) -> HttpResponse {
    if let Ok(mut file) = File::create("events.json") {
        if let Err(e) = file.write_all(serde_json::to_string(&data).unwrap().as_bytes()) {
            eprintln!("Failed to write data to file: {}", e);
            return HttpResponse::InternalServerError().finish();
        }
        eprintln!("Working on!");
        HttpResponse::Ok().finish()
    } else {
        HttpResponse::InternalServerError().finish()
    }
}

async fn export_handler() -> Result<web::Json<serde_json::Value>> {
    let content = fs::read_to_string("events.json")?;
    let json_data: serde_json::Value = serde_json::from_str(&content)?;
    Ok(web::Json(json_data))
}

#[actix_web::main]
async fn main() -> io::Result<()> {
    HttpServer::new(|| {
        let wrap = App::new().wrap(
            Cors::permissive()
                .allow_any_origin()
                .allowed_methods(vec!["GET", "POST"]),
        );
        wrap.route("/upload", web::post().to(upload_handler))
            .route("/export", web::get().to(export_handler))
    })
    .bind("127.0.0.1:8080")?
    .run()
    .await
}
