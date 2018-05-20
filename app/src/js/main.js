
function subir_modal(){
	window.addEventListener('load',function(){
		document.querySelector('.modal-loading').classList.add('on');
		setTimeout(function(){
			document.querySelector('body').classList.remove('off');
			document.querySelector('.banner').classList.add('on');
		}, 1500);
	});
}
function paralax_banner(){
	window.addEventListener('scroll', function(){
		var scroll = window.scrollTop;
		console.log(scroll);
	})
}

paralax_banner();
subir_modal();