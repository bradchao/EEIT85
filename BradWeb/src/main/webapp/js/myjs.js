window.onload = function(){
	let start = document.getElementById('start');
	let mesgDiv = document.getElementById('mesgDiv');
	let mesg = document.getElementById('mesg');
	let send = document.getElementById('send');
	let log = document.getElementById('log');
	
	let webSocket;
	
	start.addEventListener('click', function(){
		webSocket = new WebSocket("ws://localhost:8080/BradWeb/myserver");
		webSocket.onopen = function(){
			console.log("opOpen");
		};
		webSocket.onerror = function(){
			console.log("opError");
		};
		
	});
	
	send.addEventListener('click', function(){
		
	});
	
	start.style.display = 'block';
	mesgDiv.style.display = 'none';
	
	
}