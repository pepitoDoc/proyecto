<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
        <div class="row">
            <h2 id="titulo" class="text-center mt-2">Menú principal</h2>
        </div>
        <div class="row mt-4 row d-flex justify-content-center">
          <div class="col-3">
            <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Área de usuario
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="registro/registro.jsp">Registrarse como usuario</a></li>
                <li><a class="dropdown-item" href="modificar/modificar.jsp">Modificar datos</a></li>
                <li><a class="dropdown-item" href="borrar/borrar.jsp">Borrar usuario</a></li>
              </ul>
            </div>
          </div>
          <div class="col-2">
            <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Jugar
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="sieteSetup/setup.jsp">Jugar al siete y medio</a></li>
                <li><a class="dropdown-item" href="rayaSetup/setup.jsp">Jugar al cuatro en raya</a></li>
              </ul>
            </div>
          </div>
          <div class="col-2">
            <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Buscar partidas
              </button>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="sieteBusqueda/busqueda.jsp">Buscar partidas de siete y medio</a></li>
                <li><a class="dropdown-item" href="rayaBusqueda/busqueda.jsp">Buscar partidas de cuatro en raya</a></li>
                <li><a class="dropdown-item" href="ranking/ranking.jsp">Ranking de jugadores</a></li>
              </ul>
            </div>
          </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>