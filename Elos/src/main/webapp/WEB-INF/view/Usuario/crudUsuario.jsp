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
    <form action="${pageContext.request.contextPath}/usuario-insert" method="post" target="_top">
        <table border="3px">
            <tr>
                <th>Tipo de Usuário</th>
                <th>Email</th>
                <th>Senha</th>
                <th>Nome</th>
                <th>Raio de procura em km</th>

            </tr>
            <tr>

                    <td>
                        <label for="tipoUsuario">Tipo do usuário: </label>
                        <input type="text" id="tipoUsuario" name="tipoUsuario" required>
                    </td>

                    <td>
                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" required>
                    </td>

                    <td>
                        <label for="senha">Senha:</label>
                        <input type="text" id="senha" name="senha" required>
                    </td>

                    <td>
                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" required>
                    </td>

                    <td>
                        <label for="raioProcuraKm">Raio de procura em km:</label>
                        <input type="text" id="raioProcuraKm" name="raioProcuraKm" required>
                    </td>

                    <button type="submit">Enviar</button>
                    <button id="close">Sair</button>

            </tr>

        </table>
    </form>

</dialog>


<script>

    const butao = document.getElementById("butao")
    const modal = document.getElementById("dialog")

    const butao1 = document.getElementById("close")


    butao.onclick = function(){

        modal.showModal()

    }

    butao1.onclick = function(){

        modal.close()

    }


</script>



</body>
</html>
