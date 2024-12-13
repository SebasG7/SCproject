<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Unidades</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Gestión de Unidades</h2>
        <a href="editar_unidad.jsp" class="btn btn-success mb-3">Agregar Nueva Unidad</a>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Abreviatura</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="unidad" items="${unidades}">
                    <tr>
                        <td>${unidad.id}</td>
                        <td>${unidad.nombre}</td>
                        <td>${unidad.abreviatura}</td>
                        <td>
                            <a href="UnidadesServlet?action=editar&id=${unidad.id}" class="btn btn-primary btn-sm">Editar</a>
                            <a href="UnidadesServlet?action=eliminar&id=${unidad.id}" class="btn btn-danger btn-sm"
                               onclick="return confirm('¿Estás seguro de que deseas eliminar esta unidad?');">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
