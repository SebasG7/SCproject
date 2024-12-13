<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Categoría</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4"><c:if test="${categoria != null}">Editar Categoría</c:if><c:if test="${categoria == null}">Agregar Nueva Categoría</c:if></h2>
        <form action="CategoriasServlet" method="post">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${categoria.nombre}" required>
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required>${categoria.descripcion}</textarea>
            </div>
            <c:if test="${categoria != null}">
                <input type="hidden" name="id" value="${categoria.id}">
            </c:if>
            <button type="submit" class="btn btn-primary"><c:if test="${categoria != null}">Actualizar</c:if><c:if test="${categoria == null}">Guardar</c:if></button>
            <a href="CategoriasServlet" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
