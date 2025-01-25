<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesi�n</title>
</head>
<body>
    <h1>Inicio de Sesi�n</h1>
    <form id="loginForm">
        <label for="username">Nombre de Usuario:</label><br>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Contrase�a:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        
        <button type="button" id="submit" onclick="login()">Iniciar Sesi�n</button>
    </form>

    <p id="success" style="color: green; display: none;">�Inicio de sesi�n exitoso!</p>
    <p id="error" style="color: red; display: none;">Error: Usuario o contrase�a incorrectos.</p>

    <script>
        function login() {
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;

            // Simulaci�n de verificaci�n con datos est�ticos
            if (username === "usuario_valido" && password === "password_correcto") {
                document.getElementById('success').style.display = 'block';
                document.getElementById('error').style.display = 'none';
            } else {
                document.getElementById('success').style.display = 'none';
                document.getElementById('error').style.display = 'block';
            }
        }
    </script>
</body>
</html>
