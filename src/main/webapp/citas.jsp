<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro de Citas</title>
</head>
<body>
	<h1>Registro de Citas</h1>
	<form id="citasForm">
		<label for="horario">Seleccione un horario:</label><br> <select
			id="horario" name="horario" required>
			<option value="10:00 AM">10:00 AM</option>
			<option value="11:00 AM">11:00 AM</option>
			<option value="2:00 PM">2:00 PM</option>
			<option value="3:00 PM">3:00 PM</option>
		</select><br>
		<br>

		<button type="button" id="confirmar" onclick="registrarCita()">Confirmar
			Cita</button>
	</form>

	<p id="success" style="color: green; display: none;">¡Cita
		registrada exitosamente!</p>

	<script>
        function registrarCita() {
            const horario = document.getElementById('horario').value;

            // Simulación de registro de cita
            if (horario) {
                document.getElementById('success').style.display = 'block';
            }
        }
    </script>
</body>
</html>
