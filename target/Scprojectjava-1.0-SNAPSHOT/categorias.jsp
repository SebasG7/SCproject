<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Categorías</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Gestión de Categorías</h2>
        <a href="editar_categoria.jsp" class="btn btn-success mb-3">Agregar Nueva Categoría</a>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="categoria" items="${categorias}">
                    <tr>
                        <td>${categoria.id}</td>
                        <td>${categoria.nombre}</td>
                        <td>${categoria.descripcion}</td>
                        <td>
                            <a href="CategoriasServlet?action=editar&id=${categoria.id}" class="btn btn-primary btn-sm">Editar</a>
                            <a href="CategoriasServlet?action=eliminar&id=${categoria.id}" class="btn btn-danger btn-sm"
                               onclick="return confirm('¿Estás seguro de que deseas eliminar esta categoría?');">Eliminar</a>
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
