if ("serviceWorker" in navigator) {
  navigator.serviceWorker
    .register("/sw.js")
    .then(function (registration) {
      console.log("Service Worker registered with scope:", registration.scope);
    })
    .catch(function (error) {
      console.error("Service Worker registration failed:", error);
    });
}

const daysContainer = document.querySelector(".days"),
  nextBtn = document.querySelector(".next-btn"),
  prevBtn = document.querySelector(".prev-btn"),
  month = document.querySelector(".month"),
  todayBtn = document.querySelector(".today-btn");

const months = [
  "Januar",
  "Februar",
  "März",
  "April",
  "Mai",
  "Juni",
  "Juli",
  "August",
  "September",
  "Oktober",
  "November",
  "Dezember",
];

const days = [
  "Montag",
  "Dienstag",
  "Mittwoch",
  "Donnerstag",
  "Freitag",
  "Samstag",
  "Sonntag",
];

//Dark mode
const themaIcon = document.getElementById("darkmode-icon");

themaIcon.addEventListener("click", function () {
  document.body.classList.toggle("dark-theme");
  themaIcon.src = document.body.classList.contains("dark-theme")
    ? "images/sun.png"
    : "images/moon.png";
});

let currentDate = new Date();
let currentMonth = currentDate.getMonth();
let currentYear = currentDate.getFullYear();

const openModalBtn = document.getElementById("openModalBtn");
const closeModalBtn = document.getElementById("closeModalBtn");
const modal = document.getElementById("myModal");

document.addEventListener("DOMContentLoaded", function () {
  // Function to render days
  function renderCalendar() {
    // Get year-month-days
    currentDate.setDate(1);
    const firstDay = new Date(currentYear, currentMonth, 1);
    const lastDay = new Date(currentYear, currentMonth + 1, 0);
    const lastDayIndex = lastDay.getDay();
    const lastDayDate = lastDay.getDate();
    const prevLastDay = new Date(currentYear, currentMonth, 0);
    const prevLastDayDate = prevLastDay.getDate();
    const nextDays = 7 - lastDayIndex - 1;

    month.innerHTML = `${months[currentMonth]} ${currentYear}`;

    let days = "";

    for (let x = (firstDay.getDay() + 6) % 7; x > 0; x--) {
      days += `<div class="day prev">${prevLastDayDate - x + 1}</div>`;
    }

    for (let i = 1; i <= lastDayDate; i++) {
      if (
        i === new Date().getDate() &&
        currentMonth === new Date().getMonth() &&
        currentYear === new Date().getFullYear()
      ) {
        // if date month year matches add today
        days += `<div class="day today">${i}</div>`;
      } else {
        days += `<div class="day ">${i}</div>`;
      }
    }
    for (let j = 1; j <= (nextDays + 1) % 7; j++) {
      days += `<div class="day next">${j}</div>`;
    }

    if (lastDayIndex == 31) {
      for (let j = 1; j <= nextDays; j++) {
        days += `<div class="day next">${j}</div>`;
      }
    }
    daysContainer.innerHTML = days;
  }

  renderCalendar();

  // next month button
  nextBtn.addEventListener("click", () => {
    currentMonth++;
    if (currentMonth > 11) {
      currentMonth = 0;
      currentYear++;
    }
    renderCalendar();
  });

  // prev month button
  prevBtn.addEventListener("click", () => {
    currentMonth--;
    if (currentMonth < 0) {
      currentMonth = 11;
      currentYear--;
    }
    renderCalendar();
  });

  // go to today
  todayBtn.addEventListener("click", () => {
    currentMonth = currentDate.getMonth();
    currentYear = currentDate.getFullYear();
    renderCalendar();
  });

  function updateClock() {
    let now = new Date();
    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();

    // Converting hour, minute and second
    hours = padZero(hours);
    minutes = padZero(minutes);
    seconds = padZero(seconds);

    // Update time
    let clockElement = document.getElementById("clock");
    clockElement.textContent = hours + ":" + minutes + ":" + seconds;
  }

  function padZero(value) {
    return value < 10 ? "0" + value : value;
  }

  setInterval(updateClock, 1000);
  updateClock();

  openModalBtn.addEventListener("click", function () {
    modal.style.display = "block";
    eventForm.reset();
  });

  closeModalBtn.addEventListener("click", function () {
    modal.style.display = "none";
  });
});

document.addEventListener("DOMContentLoaded", function () {
  function saveEventsToLocalStorage() {
    localStorage.setItem("events", JSON.stringify(events));
  }

  let events = JSON.parse(localStorage.getItem("events")) || [];

  function saveEventsToLocalStorage() {
    localStorage.setItem("events", JSON.stringify(events));
  }

  // Save button
  document
    .getElementById("saveEventBtn")
    .addEventListener("click", function () {
      let eventName = document.getElementById("eventName").value;
      let startTime = new Date(document.getElementById("startTime").value);
      let endTime = new Date(document.getElementById("endTime").value);
      let description = document.getElementById("description").value;
      let category = document.getElementById("category").value;

      // Check if the event is within the allowed time range
      let sixMonthsAhead = new Date();
      sixMonthsAhead.setMonth(sixMonthsAhead.getMonth() + 6);
      let sixMonthsAgo = new Date();
      sixMonthsAgo.setMonth(sixMonthsAgo.getMonth() - 6);

      if (startTime < sixMonthsAgo || endTime > sixMonthsAhead) {
        alert(
          "Events cannot be added 6 months before today or 6 months after today."
        );
        return false;
      }

      if (!eventName || !startTime || !endTime) {
        alert("Bitte füllen Sie alle Felder außer Beschreibung aus!");
        return false;
      }

      if (startTime >= endTime) {
        alert("Das Ende muss nach dem Anfang liegen!");
        return false;
      }

      // Create main event object
      let mainEvent = {
        eventName: eventName,
        startTime: startTime,
        endTime: endTime,
        description: description,
        category: category,
      };

      events.push(mainEvent);

      saveEventsToLocalStorage();
      modal.style.display = "none";

      triggerClickOnCurrentDay();
    });

  // Show today's event without clicking
  function triggerClickOnCurrentDay() {
    const currentDay = new Date().getDate();
    const daysContainer = document.querySelector(".days");
    const dayElements = daysContainer.querySelectorAll(".day");

    let currentDayElement;

    dayElements.forEach((element) => {
      if (element.textContent.trim() === currentDay.toString()) {
        currentDayElement = element;
      }
    });

    if (currentDayElement) {
      currentDayElement.click();
    }
  }

  const daysContainer = document.querySelector(".days");
  daysContainer.addEventListener("click", function (event) {
    const clickedDay = event.target.textContent;

    const eventsForClickedDay = events.filter(function (event) {
      const eventDate = new Date(event.startTime);
      const eventDay = eventDate.getDate();
      const eventMonth = eventDate.getMonth();
      const eventYear = eventDate.getFullYear();

      // Convert clicked day to a number
      const clickedDayNumber = parseInt(clickedDay, 10);

      return (
        eventDay === clickedDayNumber &&
        eventMonth === currentMonth && // Consider the current month
        eventYear === currentYear // Consider the current year
      );
    });

    displayEventsInRightContainer(eventsForClickedDay);
  });

  const eventsList = document.querySelector(".events-list");

  //display events in the right container
  if (eventsList) {
    function displayEventsInRightContainer(events) {
      const rightContainer = document.querySelector(".right-container");
      const planText = document.createElement("div");

      eventsList.innerHTML = "";

      events.forEach(function (event) {
        const listItem = document.createElement("li");
        const timeRange = getTimeRange(event.startTime, event.endTime);

        listItem.innerHTML = `<strong>${timeRange}</strong> - ${
          event.eventName
        }<br><em>Kategorie:</em> ${event.category}<br>
         <em>Beschreibung:</em> ${event.description || "Keine Beschreibung"}`;

        eventsList.appendChild(listItem);
      });
    }
  }

  function displayEventsInRightContainer(events) {
    const resultContainer = document.getElementById("resultContainer");
    resultContainer.innerHTML = "";

    const currentMonth = new Date().getMonth();
    const aggregatedEvents = aggregateEventsByName(events);
  }
  displayEventsInRightContainer(events);

  // Function to get time range from start time to end time
  function getTimeRange(startTime, endTime) {
    const start = new Date(startTime);
    const end = new Date(endTime);

    const formatOptions = { hour: "2-digit", minute: "2-digit" };
    const startTimeString = start.toLocaleTimeString("de-DE", formatOptions);
    const endTimeString = end.toLocaleTimeString("de-DE", formatOptions);

    return `${startTimeString} - ${endTimeString}`;
  }

  // Auswertung
  function calculateTimeSpent(eventName, month) {
    var totalHours = 0;

    events.forEach(function (event) {
      // Check if the event's month matches the selected month
      if (new Date(event.startTime).getMonth() === month) {
        // Check if the event's name matches the specified eventName
        if (event.eventName === eventName) {
          // Calculate the time difference in hours
          var startTime = new Date(event.startTime);
          var endTime = new Date(event.endTime);
          var timeDifference = (endTime - startTime) / (1000 * 60 * 60); // Convert milliseconds to hours

          // Add the time difference to the total
          totalHours += timeDifference;
        }
      }
    });

    return totalHours;
  }

  // Function to display the results
  function displayResults() {
    var month = prompt("Enter the month (1-12):");

    if (month !== null) {
      month = parseInt(month, 10) - 1; // Adjust month to match JavaScript's 0-based index

      if (isNaN(month) || month < 0 || month > 11) {
        alert("Invalid month. Please enter a number between 1 and 12.");
      } else {
        var resultContainer = document.getElementById("resultContainer");
        resultContainer.innerHTML = ""; // Clear previous results

        // Iterate through unique event names and calculate time spent
        var uniqueEventNames = [
          ...new Set(events.map((event) => event.eventName)),
        ];
        uniqueEventNames.forEach(function (eventName) {
          var totalHours = calculateTimeSpent(eventName, month);

          // Display results only for events with total time greater than 0
          if (totalHours > 0) {
            var resultItem = document.createElement("div");
            resultItem.textContent =
              eventName + ": " + totalHours.toFixed(2) + " hours";
            resultContainer.appendChild(resultItem);
          }
        });
      }
    }
  }

  // Attach the displayResults function to the auswertungBtn button
  var auswertungBtn = document.getElementById("auswertungBtn");
  auswertungBtn.addEventListener("click", displayResults);

  // Event löschen
  const deleteEventBtn = document.getElementById("deleteEventBtn");
  const deleteModal = document.getElementById("deleteModal");
  const closeDeleteModalBtn = document.getElementById("closeDeleteModalBtn");
  const deleteDateInput = document.getElementById("deleteDate");
  const deleteEventsSelect = document.getElementById("deleteEvents");
  const confirmDeleteBtn = document.getElementById("confirmDeleteBtn");

  deleteEventBtn.addEventListener("click", function () {
    deleteModal.style.display = "block";

    deleteDateInput.valueAsDate = new Date();

    updateEventsDropdown();

    closeDeleteModalBtn.addEventListener("click", function () {
      deleteModal.style.display = "none";
    });
  });

  deleteDateInput.addEventListener("change", updateEventsDropdown);

  confirmDeleteBtn.addEventListener("click", function () {
    const selectedDate = deleteDateInput.value;
    const selectedEventsCheckboxes = document.querySelectorAll(
      'input[name="deleteEventsCheckbox"]:checked'
    );

    const selectedEvents = Array.from(selectedEventsCheckboxes).map(
      (checkbox) => checkbox.value
    );
    deleteSelectedEvents(selectedDate, selectedEvents);

    deleteModal.style.display = "none";
    triggerClickOnCurrentDay();
  });

  function updateEventsDropdown() {
    const selectedDate = deleteDateInput.value;
    const eventsForSelectedDate = getEventsForDate(selectedDate);

    const deleteEventsContainer = document.getElementById(
      "deleteEventsContainer"
    );
    deleteEventsContainer.innerHTML = "";

    const selectedCategory = document.getElementById("category").value;

    // Add checkboxes for each event
    eventsForSelectedDate.forEach(function (event) {
      const checkbox = document.createElement("input");
      checkbox.type = "checkbox";
      checkbox.name = "deleteEventsCheckbox";
      checkbox.id = "deleteEvents";
      checkbox.value = event.eventName;

      const label = document.createElement("label");
      label.textContent = `${event.eventName} - ${event.startTime}`;
      label.appendChild(checkbox);

      deleteEventsContainer.appendChild(label);
    });
  }

  // Function to get events for a specific date
  function getEventsForDate(date) {
    const events = JSON.parse(localStorage.getItem("events")) || [];
    return events.filter(function (event) {
      return event.startTime.startsWith(date);
    });
  }

  // Function to delete selected events from local storage and update the events array
  function deleteSelectedEvents(date, selectedEvents) {
    let events = JSON.parse(localStorage.getItem("events")) || [];
    events = events.filter(function (event) {
      return !(
        event.startTime.startsWith(date) &&
        selectedEvents.includes(event.eventName)
      );
    });

    // Save updated events to local storage
    localStorage.setItem("events", JSON.stringify(events));

    // Update the events array used in the rest of the code
    updateEventsArray();

    // Trigger the click event on the currently selected day
    const selectedDay = document.querySelector(".day.selected");
    if (selectedDay) {
      selectedDay.click();
    }
    triggerClickOnCurrentDay();
  }

  /* Alternative for exporting events to a JSON file without rust server
  document
    .getElementById("exportEventsBtn")
    .addEventListener("click", function () {
      const eventsData = JSON.stringify(events);
      const blob = new Blob([eventsData], { type: "application/json" });
      const url = URL.createObjectURL(blob);

      const a = document.createElement("a");
      a.href = url;
      a.download = "events.json";
      document.body.appendChild(a);
      a.click();

      // Cleanup
      document.body.removeChild(a);
      URL.revokeObjectURL(url);
    });
  */

  // Send data every minute to backup server
  const eventsData = JSON.parse(localStorage.getItem("events"));

  const sendEventsInterval = setInterval(() => {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://127.0.0.1:8080/upload");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = () => {
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log("Events data sent successfully");
      } else {
        console.error("Failed to send events data");
      }
    };

    xhr.send(JSON.stringify(eventsData));
  }, 600000);

  // Export events from rust server
  function exportFromBackUp() {
    fetch("http://127.0.0.1:8080/export")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch events.json");
        }
        return response.json();
      })
      .then((data) => {
        // Handle the data retrieved from the server (data contains events.json content)
        console.log("Data from server:", data);

        // Convert data to JSON string
        const jsonData = JSON.stringify(data);

        // Create a Blob from the JSON string
        const blob = new Blob([jsonData], { type: "application/json" });

        // Create a link element
        const a = document.createElement("a");
        a.href = URL.createObjectURL(blob);

        // Set the file name
        a.download = "events.json";

        // Append the link to the body
        document.body.appendChild(a);

        // Trigger a click on the link to start the download
        a.click();

        // Remove the link from the body
        document.body.removeChild(a);
      })
      .catch((error) => {
        console.error("Error fetching events.json:", error.message);
      });
  }

  document.getElementById("exportBtn").addEventListener("click", function () {
    exportFromBackUp();
  });

  // Import events from a JSON file
  document.getElementById("importBtn").addEventListener("click", function () {
    document.getElementById("importEventsBtn").click();
  });

  document
    .getElementById("importEventsBtn")
    .addEventListener("change", function (event) {
      const fileInput = event.target;
      const file = fileInput.files[0];

      if (file) {
        const reader = new FileReader();

        reader.onload = function (e) {
          try {
            const importedEvents = JSON.parse(e.target.result);
            if (Array.isArray(importedEvents)) {
              // Clear existing events and add imported events
              events = importedEvents;
              saveEventsToLocalStorage();
              // You may want to update your UI or perform any necessary actions here
              console.log("Events imported successfully.");
            } else {
              console.error("Invalid file format.");
            }
          } catch (error) {
            console.error("Error parsing file:", error);
          }
        };

        reader.readAsText(file);
      }
    });

  // Function to update the events array used in the rest of the code
  function updateEventsArray() {
    events = JSON.parse(localStorage.getItem("events")) || [];
  }

  triggerClickOnCurrentDay();
});
