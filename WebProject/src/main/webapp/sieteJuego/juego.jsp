<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <!--Juego de las siete y media, para 3 jugadores, almacenando las partidas, y con una gestión de consultas de las partidas por jugadores
    Se han de almacenar las partidas, y debe incluir una gestión de consulta de partidas por jugadores-->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Juego</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link href="juego.css" rel="stylesheet" />
  </head>
  <body>
    <div class="container">
        <div class="row">
            <h1 class="text-center">Siete y medio</h1>
        </div>
        <div class="row">
            <h4 class="text-center mt-4" id="turno">ee</h4>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-2 mt-4">
              <button type="button" class="btn btn-primary" id="bocarriba">Carta bocarriba</button>
            </div>
            <div class="col-2 mt-4">
              <button type="button" class="btn btn-primary" id="bocabajo">Carta bocabajo</button>
            </div>
            <div class="col-2 mt-4">
              <button type="button" class="btn btn-primary" id="plantarse">Plantarse</button>
            </div>
          </div>
          <div class="row justify-content-md-center mt-4" id="cartas"></div>
        </div>
    </div>

    <form id="registerData" action="/WebProject/register-game" method="POST">
      <input type="hidden" name="player1" value="">
      <input type="hidden" name="player2" value="">
      <input type="hidden" name="player3" value="">
      <input type="hidden" name="dealer" value="">
      <input type="hidden" name="player1score" value="">
      <input type="hidden" name="player2score" value="">
      <input type="hidden" name="player3score" value="">
      <input type="hidden" name="dealerScore" value="">
      <input type="hidden" name="player1bet" value="">
      <input type="hidden" name="player2bet" value="">
      <input type="hidden" name="player3bet" value="">
    </form>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript" src="juego.js"></script>

  </body>
</html>