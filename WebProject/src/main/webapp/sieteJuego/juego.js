const baraja = [4, 4, 4, 4, 4, 4, 4, 4, 4, 4];
const cartasRestantes = [];
for (let i = 0; i <= baraja.length; i++) {
  cartasRestantes.push(["basto", "copa", "espada", "oro"]);
}

const nombres = JSON.parse(sessionStorage.getItem("nombres"));
const resultadoPartida = [];

let puntuacionValue = 0;
let nroJugador = 0;

const bloqueCartas = document.querySelector("#cartas");
const colSpace = document.createElement("div");
colSpace.classList.add("col-2");

document.addEventListener("DOMContentLoaded", initialize, false);

function initialize() {
  const nombreTurno = document.querySelector("#turno");
  nombreTurno.textContent = nombres[nroJugador] + " (Número " + (nroJugador+1) + ")";
  if (nroJugador == 0) {
    document.querySelector("#bocarriba").addEventListener("click", (e) => {
      generarCarta(e);
    });
    document.querySelector("#bocabajo").addEventListener("click", (e) => {
      generarCarta(e);
    });
    document.querySelector("#plantarse").addEventListener("click", (e) => {
      nextTurn();
    });
  }
  abajo(obtenerNumero());
}

function generarCarta(e) {
  let numeroGenerado = obtenerNumero();
  if (e.target == document.querySelector("#bocarriba")) {
    const clone = pintarImagen(numeroGenerado);
    document.querySelector("#cartas").appendChild(clone);
    if (puntuacionValue > 7.5) {
      alert("Puntuacio sobrepasada con " + puntuacionValue);
      nextTurn();
    }
  } else {
    const oldCartaAbajo = document.querySelector("#imagenHide");
    oldCartaAbajo.src = oldCartaAbajo.getAttribute("showUrl");
    oldCartaAbajo.removeEventListener("mouseleave", hideValue);
    oldCartaAbajo.id = "imagen";
    oldCartaAbajo.removeAttribute("showUrl");
    abajo(numeroGenerado);
    if (puntuacionValue > 7.5) {
      alert("Puntuacio sobrepasada con " + puntuacionValue);
      nextTurn();
    }
  }
}

function pintarImagen(numeroGenerado) {
  const clone = colSpace.cloneNode(true);
  const palo = obtenerPalo(numeroGenerado);
  const imagenCartas = new Image(100, 200);
  if (numeroGenerado > 6) {
    numeroGenerado += 3;
  } else {
    numeroGenerado += 1;
  }
  imagenCartas.id = "imagen";
  imagenCartas.src = "AllCards/" + palo + numeroGenerado + ".png";
  clone.appendChild(imagenCartas);
  return clone;
}

function abajo(numeroGenerado) {
  const clone = pintarImagen(numeroGenerado);
  const imagen = clone.querySelector("#imagen");
  const showUrlFull = imagen.src;
  //const showUrl = imagen.src.substring(28);
  imagen.setAttribute("showUrl", showUrlFull);
  imagen.id = "imagenHide";
  imagen.src = "AllCards/dorso.png";
  imagen.addEventListener("mouseenter", () => {
    imagen.src = showUrlFull;
  });
  imagen.addEventListener(
    "mouseleave",
    (hideValue = function fn() {
      imagen.src = "AllCards/dorso.png";
    }),
    false
  );
  document.querySelector("#cartas").appendChild(clone);
}

function obtenerNumero() {
  let eleccion = Math.floor(Math.random() * 9);
  let numeroGenerado = 0;
  if (baraja[eleccion] != 0) {
    baraja[eleccion]--;
    if (eleccion > 6) {
      numeroGenerado = 0.5;
    } else {
      numeroGenerado = eleccion + 1;
    }
  } else {
    obtenerNumero();
  }
  puntuacionValue += numeroGenerado;
  return eleccion;
}

function obtenerPalo(eleccion) {
  const random = Math.floor(
    Math.random() * (cartasRestantes[eleccion].length - 1)
  );
  const palo = cartasRestantes[eleccion][random];
  cartasRestantes[eleccion].splice(random, 1);
  return palo;
}

function nextTurn() {
  resultadoPartida.push(puntuacionValue);
  if (nroJugador == 3) {
    sessionStorage.setItem(
      "resultadoPartida",
      JSON.stringify(resultadoPartida)
    );
    const nombres = JSON.parse(sessionStorage.getItem("nombres"));
    const apuestas = JSON.parse(sessionStorage.getItem("apuestas"));
    submitFormData(nombres, apuestas);
  } else {
    nroJugador++;
    puntuacionValue = 0;
    document.querySelector("#cartas").innerHTML = '';
    initialize();
  }
}

function submitFormData(nombres, apuestas) {
  const formData = document.querySelector("#registerData");
  const player1Input = formData.querySelector('input[name="player1"]');
  const player2Input = formData.querySelector('input[name="player2"]');
  const player3Input = formData.querySelector('input[name="player3"]');
  const dealerInput = formData.querySelector('input[name="dealer"]');
  const player1ScoreInput = formData.querySelector(
    'input[name="player1score"]'
  );
  const player2ScoreInput = formData.querySelector(
    'input[name="player2score"]'
  );
  const player3ScoreInput = formData.querySelector(
    'input[name="player3score"]'
  );
  const dealerScoreInput = formData.querySelector('input[name="dealerScore"]');
  const player1BetInput = formData.querySelector('input[name="player1bet"]');
  const player2BetInput = formData.querySelector('input[name="player2bet"]');
  const player3BetInput = formData.querySelector('input[name="player3bet"]');

  player1Input.value = nombres[0];
  player2Input.value = nombres[1];
  player3Input.value = nombres[2];
  dealerInput.value = nombres[3];
  player1ScoreInput.value = resultadoPartida[0];
  player2ScoreInput.value = resultadoPartida[1];
  player3ScoreInput.value = resultadoPartida[2];
  dealerScoreInput.value = resultadoPartida[3];
  player1BetInput.value = apuestas[0];
  player2BetInput.value = apuestas[1];
  player3BetInput.value = apuestas[2];

  formData.submit();
}
