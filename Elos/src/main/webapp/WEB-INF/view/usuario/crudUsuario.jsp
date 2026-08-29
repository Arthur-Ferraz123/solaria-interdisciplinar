<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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

<!-- Exibe mensagens de erro vindas do ReadUsuarioServlet, se houver -->
<c:if test="${not empty errosEncontrados}">
    <div style="border:1px solid red; background:#ffe6e6; padding:10px; margin-bottom:10px;">
        <ul>
            <c:forEach var="erro" items="${errosEncontrados}">
                <li>${erro}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<table border="3px">
    <tr>
        <th>ID</th>
        <th>Tipo de Usuário</th>
        <th>Email</th>
        <th>Nome</th>
        <th>Raio de procura em km</th>
        <th>Ações</th>

    </tr>

    <!-- Linhas geradas a partir da lista "usuarios" retornada pelo ReadUsuarioServlet (/crudUsuario) -->
    <c:choose>
        <c:when test="${not empty usuarios}">
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.tipoUsuario}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.raioProcuraKm}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/crudUsuario-delete" method="post" style="margin: 0;">
                        <!-- O campo hidden guarda o ID mas não aparece na tela -->
                        <input type="hidden" name="id" value="${usuario.id}">

                        <!-- Seu botão vermelho X -->
                        <button type="submit" style="background-color: red; color: black; font-weight: bold;">
                            X
                        </button>

                        </form>

                        <form action="${pageContext.request.contextPath}/crudUsuario-update" method="get" style="margin: 0;">
                            <!-- O campo hidden guarda o ID mas não aparece na tela -->
                            <input type="hidden" name="idUpdate" value="${usuario.id}">

                            <!-- Seu botão vermelho X -->
                            <button id="editar" type="submit" style="background-color: red; color: black; font-weight: bold;">
                                Editar
                            </button>

                        </form>

                    </td>

                </tr>
            </c:forEach>
        </c:when>

        <c:otherwise>
            <tr>
                <td colspan="6" style="text-align:center;">Nenhum usuário encontrado</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<!-- insert-->
<div class="formulario-linha">
    <form action="${pageContext.request.contextPath}/crudUsuario" method="post">

        <!-- Campo 1: Seleção (Existente) -->
        <div class="campo">
            <label for="clausulaWhereNome">clausulaWhereNome:</label>
            <select id="clausulaWhereNome" name="clausulaWhereNome">
                <option value="nenhuma">Nenhuma</option>
                <option value="id">ID</option>
                <option value="nome">Nome</option>
                <option value="email">Email</option>
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
                <option value="nenhuma">Nenhuma</option>
                <option value="id">ID</option>
                <option value="nome">Nome</option>
                <option value="email">Email</option>
                <option value="tipo_usuario">Tipo usuário</option>
                <option value="raio_procura_km">Raio de procura em km</option>
            </select>
        </div>

        <div class="campo">
            <label for="ordenacao">Ordenação:</label>
            <select id="ordenacao" name="ordenacao">
                <option value="asc">Crescente</option>
                <option value="desc">Decrescente</option>
            </select>
        </div>


        <div style="margin-top: 10px;">
            <button type="submit">Enviar</button>
        </div>
    </form>
</div>


<!-- pop up editar-->
<dialog id="dialog1">
    <form action="${pageContext.request.contextPath}/crudUsuario-update" method="post">
        <table border="3px">
            <tr>
                <th><label for="idUpdate">ID</label></th>
                <th><label for="tipoUsuarioUpdate">Tipo do usuário</label></th>
                <th><label for="emailUpdate">Email</label></th>
                <th><label for="senhaUpdate">Senha</label></th>
                <th><label for="nomeUpdate">Nome</label></th>
                <th><label for="raioProcuraKmUpdate">Raio de procura em km</label></th>
            </tr>
            <tr>
                <td>${usuarioUpdate.id}</td>
                <td>${usuarioUpdate.tipoUsuario}</td>
                <td><input type="text" id="emailUpdate" name="emailUpdate" value="${usuarioUpdate.email}"required></td>
                <td><input type="text" id="senhaUpdate"></td>
                <td><input type="text" id="nomeUpdate" name="nomeUpdate" value="${usuarioUpdate.nome}" required></td>
                <td><input type="text" id="raioProcuraKmUpdate" name="raioProcuraKmUpdate" value="${usuarioUpdate.raioProcuraKm}"required></td>
            </tr>
        </table>

        <div style="margin-top: 10px;">
            <button type="submit">Enviar</button>
            <button type="button" id="fechar">Sair</button>
        </div>
    </form>
</dialog>

<br>
<br>

<button id="butao">Inserir</button>

<!-- pop up inserir -->
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
                <td>

                    <select id="tipoUsuario" name="tipoUsuario">
                        <option value="FORNECEDOR">Fornecedor</option>
                        <option value="EMPRESA_DEMANDANTE">Empresa demandante</option>
                        <option value="PROFISSIONAL">Profissional</option>
                    </select>
                </td>
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

    const butao3 = document.getElementById("editar");
    const modal1 = document.getElementById("dialog1");
    const butao4 = document.getElementById("fechar");

    butao3.onclick = function(){
        modal.showModal();
    }

    // Fecha o modal manualmente
    butao4.onclick = function(){
        modal1.close();
    }

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
