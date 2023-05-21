<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Configuración de la partida</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>

    <div class="container">

        <div class="row">
            <h2 id="titulo" class="text-center mt-2 mb-2">Configuración de la partida</h2>
        </div>
        <div class="row">
            <div class="col-6">
                <h4 class="text-center mt-4 mb-4">Jugador 1</h4>
                <div class="row d-flex justify-content-center">
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="1" name="setup1" id="jugarSin">
                            <label class="form-check-label" for="jugarSin">
                              Jugar sin usuario
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="1" name="setup1" id="jugarCon">
                            <label class="form-check-label" for="jugarCon">
                            Jugar con usuario registrado
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row" id="input1">

                </div>
            </div>
            <div class="col-6">
                <h4 class="text-center mt-4 mb-4">Jugador 2</h4>
                <div class="row d-flex justify-content-center">
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="2" name="setup2" id="jugarSin">
                            <label class="form-check-label" for="jugarSin">
                              Jugar sin usuario
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="2" name="setup2" id="jugarCon">
                            <label class="form-check-label" for="jugarCon">
                            Jugar con usuario registrado
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row" id="input2">

                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <h4 class="text-center mt-4 mb-4">Jugador 3</h4>
                <div class="row d-flex justify-content-center">
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="3" name="setup3" id="jugarSin">
                            <label class="form-check-label" for="jugarSin">
                              Jugar sin usuario
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="3" name="setup3" id="jugarCon">
                            <label class="form-check-label" for="jugarCon">
                            Jugar con usuario registrado
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row" id="input3">

                </div>
            </div>
            <div class="col-6">
                <h4 class="text-center mt-4 mb-4">Banca</h4>
                <div class="row d-flex justify-content-center">
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="4" name="setup4" id="jugarSin">
                            <label class="form-check-label" for="jugarSin">
                              Jugar sin usuario
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="4" name="setup4" id="jugarCon">
                            <label class="form-check-label" for="jugarCon">
                            Jugar con usuario registrado
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row" id="input4">

                </div>
            </div>
        </div>
        <div class="row">
            <div class="col d-flex justify-content-center mt-4">
                <button type="submit" class="btn btn-primary" id="botonComenzar">Comenzar partida</button>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="inputControl.js"></script>
  </body>
</html>