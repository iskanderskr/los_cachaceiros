<div class="produtos">
	<hgroup>
		<h1>Confira nossos produtos</h1>
	</hgroup>
	<section>
		<c:forEach items="${bebidas}" var="bebida">
			<a href="#">
				<picture>
					<img src="img/img1.jpg">
				</picture>
				<div class="descricao">
					<div class="nome">${bebida.nome}</div>
					<div class="preco">${bebida.preco}</div>
				</div>
			</a>
		</c:forEach>
	</section>
	
</div>