<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Producto</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4"><c:if test="${producto != null}">Editar Producto</c:if><c:if test="${producto == null}">Agregar Nuevo Producto</c:if></h2>
        <form action="ProductosServlet" method="post">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${producto.nombre}" required>
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="3">${producto.descripcion}</textarea>
            </div>
            <div class="mb-3">
                <label for="precio" class="form-label">Precio</label>
                <input type="number" step="0.01" class="form-control" id="precio" name="precio" value="${producto.precio}" required>
            </div>
            <div class="mb-3">
                <label for="stock" class="form-label">Stock</label>
                <input type="number" class="form-control" id="stock" name="stock" value="${producto.stock}" required>
            </div>
            <div class="mb-3">
                <label for="id_categoria" class="form-label">Categoría</label>
                <select class="form-select" id="id_categoria" name="id_categoria" required>
                    <c:forEach var="categoria" items="${categorias}">
                        <option value="${categoria.id}" <c:if test="${categoria.id == producto.idCategoria}">selected</c:if>>${categoria.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="id_unidad" class="form-label">Unidad</label>
                <select class="form-select" id="id_unidad" name="id_unidad" required>
                    <c:forEach var="unidad" items="${unidades}">
                        <option value="${unidad.id}" <c:if test="${unidad.id == producto.idUnidad}">selected</c:if>>${unidad.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <c:if test="${producto != null}">
                <input type="hidden" name="id" value="${producto.id}">
            </c:if>
            <button type="submit" class="btn btn-primary"><c:if test="${producto != null}">Actualizar</c:if><c:if test="${producto == null}">Guardar</c:if></button>
            <a href="ProductosServlet" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
