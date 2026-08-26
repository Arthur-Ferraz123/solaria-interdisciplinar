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

    /* Alinha todos os elementos em uma única linha horizontal */
    .formulario-linha {
        display: flex;
        flex-wrap: wrap; /* Permite quebrar a linha se a tela for muito pequena */
        gap: 15px;       /* Cria um espaçamento igual entre os campos */
        align-items: flex-end; /* Alinha os fundos dos campos na mesma altura */
    }

    /* Organiza o rótulo acima de cada respectivo campo */
    .campo {
        display: flex;
        flex-direction: column;
    }

    /* Estilização básica para os inputs e selects ficarem padronizados */
    .campo input, .campo select {
        padding: 6px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
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

<div class="formulario-linha">
    <form action="${pageContext.request.contextPath}/crudUsuario" method="post">

    <!-- Campo 1: Seleção (Existente) -->
    <div class="campo">
        <label for="clausulaWhereNome">clausulaWhereNome:</label>
        <select id="clausulaWhereNome" name="clausulaWhereNome">
            <option value="nenhum">Nenhuma</option>
            <option value="ID">ID</option>
            <option value="email">email</option>
            <option value="tipo_usuario">Tipo usuário</option>
            <option value="raio_procura_km">Raio de procura em km</option>
        </select>
    </div>

    <!-- Campo 2: Texto (Novo) -->
    <div class="campo">
        <label for="clausulaWhereValor">clausulaWhereValor:</label>
        <input type="text" id="clausulaWhereValor" name="clausulaWhereValor" placeholder="Digite seu nome">
    </div>

    <div class="campo">
        <label for="clausulaWhereValor2">clausulaWhereValor2:</label>
        <input type="text" id="clausulaWhereValor2" name="clausulaWhereValor2">
    </div>

    <!-- Campo 3: Seleção (Novo) -->
    <div class="campo">
        <label for="orderBy">orderBy:</label>
        <select id="orderBy" name="orderBy">
            <option value="nenhum">Nenhuma</option>
            <option value="ID">ID</option>
            <option value="email">email</option>
            <option value="tipo_usuario">Tipo usuário</option>
            <option value="raio_procura_km">Raio de procura em km</option>
        </select>
    </div>


        <div style="margin-top: 10px;">
            <button type="submit">Enviar</button>
        </div>
    </form>
</div>



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
