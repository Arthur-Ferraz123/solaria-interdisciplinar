<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>

    th{

        background: green;
        color: white;
    }

</style>




<body>
<table border="3px">
    <tr>
        <th>ID</th>
        <th>Tipo de Usuário</th>
        <th>Email</th>
        <th>Senha</th>
        <th>Nome</th>
        <th>Raio de procura em km</th>

    </tr>
</table>

<br>
<br>

<button id="butao">Inserir</button>

<dialog id="dialog">
    <form action="${pageContext.request.contextPath}/crudUsuario-insert" method="post">
        <table border="3px">
            <tr>
                <th><label for="tipoUsuario">Tipo do usuário</label></th>
                <th><label for="email">Email</label></th>
                <th><label for="senha">Senha</label></th>
                <th><label for="nome">Nome</label></th>
                <th><label for="raioProcuraKm">Raio de procura em km</label></th>
            </tr>
            <tr>
                <td><input type="text" id="tipoUsuario" name="tipoUsuario" required></td>
                <td><input type="text" id="email" name="email" required></td>
                <td><input type="text" id="senha" name="senha" required></td>
                <td><input type="text" id="nome" name="nome" required></td>
                <td><input type="text" id="raioProcuraKm" name="raioProcuraKm" required></td>
            </tr>
        </table>

        <!-- Movidos para fora da tabela para manter o HTML válido -->
        <div style="margin-top: 10px;">
            <button type="submit">Enviar</button>
            <button type="button" id="close">Sair</button>
        </div>
    </form>
</dialog>

<script>

    const butao = document.getElementById("butao");
    const modal = document.getElementById("dialog");
    const butao1 = document.getElementById("close");



    // Abre o modal manualmente
    butao.onclick = function(){
        modal.showModal();
    }

    // Fecha o modal manualmente
    butao1.onclick = function(){
        modal.close();
    }


</script>

</body>
</html>
