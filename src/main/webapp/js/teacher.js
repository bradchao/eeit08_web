window.onload = function(){
	let canvas, ctx, clear;
	let webSocket = new WebSocket("ws://10.0.101.65:8080/BradWeb/?");
	
	
	clear = document.getElementById("clear");
	canvas = document.getElementById("myDrawer");
	ctx = canvas.getContext("2d");
	
	clear.addEventListener("click",function(){
		ctx.clearRect(0, 0, canvas.width, canvas.height);
	});
	
	let isDrag = false;
	canvas.onmousedown = function(e){
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		ctx.beginPath();
		ctx.lineWidth = 4;
		ctx.moveTo(x,y);
		
	};
	canvas.onmouseup = function(e){
		isDrag = false;
	};
	canvas.onmousemove = function(e){
		if (isDrag){
			let x = e.offsetX, y = e.offsetY;
			ctx.lineTo(x, y);
			ctx.stroke();
		}
		
	};
	
}