<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Unidad</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4"><c:if test="${unidad != null}">Editar Unidad</c:if><c:if test="${unidad == null}">Agregar Nueva Unidad</c:if></h2>
        <form action="UnidadesServlet" method="post">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${unidad.nombre}" required>
            </div>
            <div class="mb-3">
                <label for="abreviatura" class="form-label">Abreviatura</label>
                <input type="text" class="form-control" id="abreviatura" name="abreviatura" value="${unidad.abreviatura}" required>
            </div>
            <c:if test="${unidad != null}">
                <input type="hidden" name="id" value="${unidad.id}">
            </c:if>
            <button type="submit" class="btn btn-primary"><c:if test="${unidad != null}">Actualizar</c:if><c:if test="${unidad == null}">Guardar</c:if></button>
            <a href="UnidadesServlet" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
