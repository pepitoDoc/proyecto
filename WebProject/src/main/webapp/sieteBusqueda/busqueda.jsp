<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Busqueda por nombre</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>

    <div class="container">
      <div class="row">
        <h2 id="titulo" class="text-center mt-2 mb-2">Búsqueda por nombre</h2>
      </div>
      <div class="row">
        <div class="mb-3 mt-4 row d-flex justify-content-center">
          <label for="nickname" class="col-sm-2 col-form-label">Nombre</label>
          <div class="col-4">
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Nombre de usuario">
          </div>
        </div>
      </div>
      <div class="row d-flex justify-content-center">
        <div class="col-4 mt-4">
          <button id="botonBusqueda" type="submit" class="btn btn-primary" style="width:200px; height:40px">Buscar partidas</button>
        </div>
        <div class="col-1 mt-4">
          <form action="/WebProject/index.jsp" method="GET">
            <button type="submit" class="btn btn-secondary" style="width:200px; height:40px">Menú principal</button>
          </form>
      </div>
    </div>
    <div class="row mt-4" id="juegos">
      <div class="row" id="ranking">
        <p id="total" class= "text-center"></p>
        <p id="wins" class= "text-center"></p>
        <p id="loss" class= "text-center"></p>
        <!--<p id="most"></p>-->
      </div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Jugador 1</th>
            <th scope="col">Jugador 2</th>
            <th scope="col">Jugador 3</th>
            <th scope="col">Banca</th>
            <th scope="col">Puntuación jugador 1</th>
            <th scope="col">Puntuación jugador 2</th>
            <th scope="col">Puntuación jugador 3</th>
            <th scope="col">Puntuación banca</th>
            <th scope="col">Apuesta jugador 1</th>
            <th scope="col">Apuesta jugador 2</th>
            <th scope="col">Apuesta jugador 3</th>
            <th scope="col">Fecha partida</th>
          </tr>
        </thead>
        <tbody id="campos">
        </tbody>
      </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="busqueda.js"></script>
  </body>
</html>