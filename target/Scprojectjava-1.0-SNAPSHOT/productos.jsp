<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Productos</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Gestión de Productos</h2>
        <a href="ProductosServlet?action=nuevo" class="btn btn-success mb-3">Agregar Nuevo Producto</a>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Stock</th>
                    <th>Categoría</th>
                    <th>Unidad</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${productos}">
                    <tr>
                        <td>${producto.id}</td>
                        <td>${producto.nombre}</td>
                        <td>${producto.descripcion}</td>
                        <td>${producto.precio}</td>
                        <td>${producto.stock}</td>
                        <td>${producto.categoria}</td>
                        <td>${producto.unidad}</td>
                        <td>
                            <a href="ProductosServlet?action=editar&id=${producto.id}" class="btn btn-primary btn-sm">Editar</a>
                            <a href="ProductosServlet?action=eliminar&id=${producto.id}" class="btn btn-danger btn-sm"
                               onclick="return confirm('¿Estás seguro de que deseas eliminar este producto?');">Eliminar</a>
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
