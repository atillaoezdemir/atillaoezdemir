const cacheName = "my-cache";
const cacheFiles = [
  "/",
  "/index.html",
  "/style.css",
  "/script.js",
  "/manifest.json",
  "/images/example.png",
  "/images/manicon.png",
  "/images/moon.png",
  "/images/sun.png",
];

self.addEventListener("install", function (event) {
  event.waitUntil(
    caches.open(cacheName).then(function (cache) {
      return cache.addAll(cacheFiles);
    })
  );
});

self.addEventListener("activate", function (event) {
  event.waitUntil(
    caches.keys().then(function (cacheNames) {
      return Promise.all(
        cacheNames.map(function (existingCacheName) {
          if (existingCacheName !== cacheName) {
            return caches.delete(existingCacheName);
          }
        })
      );
    })
  );
});

self.addEventListener("fetch", function (event) {
  event.respondWith(
    caches.match(event.request).then(function (cachedResponse) {
      return (
        cachedResponse ||
        fetch(event.request).then(function (fetchResponse) {
          if (fetchResponse.status === 200) {
            // Check if the response is valid before caching
            const responseToCache = fetchResponse.clone();
            caches.open(cacheName).then(function (cache) {
              cache.put(event.request, responseToCache);
            });
          }
          return fetchResponse;
        })
      );
    })
  );
});
