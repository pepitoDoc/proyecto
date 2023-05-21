window.addEventListener(
  "DOMContentLoaded",
  () => {
    document.querySelector("#juegos").style.display = "none";
    document.querySelector("#botonBusqueda").addEventListener("click", (e) => {
      if (document.querySelector("#nickname").value != "") {
        fetchData();
      } else if (document.querySelector("#nickname").value == "No registrado") {
        alert("No se puede buscar ese nombre");
      } else {
        alert("Debe introducir un nombre para buscar");
      }
    });
  },
  false
);

function fetchData() {
  const nombre = document.querySelector("#nickname").value;
  const url = "http://localhost:8080/WebProject/findgameby-name?nombre=" + nombre;
  fetch(url, {
    method: "GET"
  })
    .then((response) => {
      if (response.headers.get("Content-Type").includes("application/json")) {
        // Handle JSON response
        return response.json();
      } else {
        // Handle text response
        return response.text();
      }
    })
    .then((data) => {
      if (data.length == 0) {
        alert("No se han encontrado partidas");
        document.querySelector("#juegos").style.display = "none";
      } else {
        generarTabla(data);
      }
    })
    .catch((error) => {
      console.error(error);
    });
}

function generarTabla(data) {
  const ranking = document.querySelector("#ranking");
  const wins = data.winCount;
  ranking.querySelector("#total").textContent = "Total de partidas: " + data.gameData.length;
  ranking.querySelector("#wins").textContent = "Partidas ganadas: " + wins;
  ranking.querySelector("#loss").textContent = "Partidas perdidas: " + (data.gameData.length - wins);
  document.querySelector("#campos").innerHTML = '';
  document.querySelector("#juegos").style.display = "inline-block";
  data.gameData.forEach((campo) => {
    // create a new table row element
    const tableRow = document.createElement("tr");

    const arrayCell = [];

    // loop through 12 times to create 12 table cell elements and append them to the table row
    for (let i = 0; i < 12; i++) {
      const tableCell = document.createElement("td");
      arrayCell.push(tableCell);
      tableRow.appendChild(tableCell);
    }

    arrayCell[0].textContent = campo.player1;
    arrayCell[1].textContent = campo.player2;
    arrayCell[2].textContent = campo.player3;
    arrayCell[3].textContent = campo.dealer;
    arrayCell[4].textContent = campo.player1score;
    arrayCell[5].textContent = campo.player2score;
    arrayCell[6].textContent = campo.player3score;
    arrayCell[7].textContent = campo.dealerScore;
    arrayCell[8].textContent = campo.player1bet;
    arrayCell[9].textContent = campo.player2bet;
    arrayCell[10].textContent = campo.player3bet;
    arrayCell[11].textContent = campo.timestamp;

    // append the table row to an existing table element or create a new table element
    const body = document.querySelector("#campos");
    body.appendChild(tableRow);
  });
}
