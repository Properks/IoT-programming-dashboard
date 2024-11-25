const available_color = "rgba(0,255,0,0.8)";
const unavailable_color = "rgba(255,0,0,0.8)";
const max_record_length = 10;

function setParking(position) {
    let parking_zone = document.getElementById(position + "-parking-zone");
    parking_zone.style.backgroundColor = unavailable_color;
}

function unsetParking(position) {
    let parking_zone = document.getElementById(position + "-parking-zone");
    parking_zone.style.backgroundColor = available_color;
}

function minusParkingNumber() {
    let element = document.getElementById("parking-remaining-status-number");
    let number = element.textContent;
    element.textContent = Number(number) - 1;
}

function plusParkingNumber() {
    let element = document.getElementById("parking-remaining-status-number");
    let number = element.textContent;
    element.textContent = Number(number) + 1;
}

function addRecord(user, time, enter) {
    let tr = document.createElement("tr");
    let userElement = document.createElement("td");
    let timeElement = document.createElement("td");
    let enterElement = document.createElement("td");

    userElement.textContent = user;
    timeElement.textContent = time;
    enterElement.textContent = enter;

    tr.appendChild(userElement);
    tr.appendChild(timeElement);
    tr.appendChild(enterElement);


    let tbody = document.getElementById("parking-past-log-table-body");
    tbody.insertBefore(tr, tbody.firstChild);

    if (tbody.childElementCount > max_record_length) {
        tbody.removeChild(tbody.lastChild);
    }
}