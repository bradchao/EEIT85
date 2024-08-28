window.onload = function(){
	let start = document.getElementById('start');
	let mesgDiv = document.getElementById('mesgDiv');
	let mesg = document.getElementById('mesg');
	let send = document.getElementById('send');
	let log = document.getElementById('log');
	
	let webSocket;
	
	start.addEventListener('click', function(){
		connect("ws://localhost:8080/BradWeb/myserver");
	});
	
	send.addEventListener('click', function(){
		let message = {
			message: mesg.value 
		};
		webSocket.send(JSON.stringify(message));
	});
	
	start.style.display = 'block';
	mesgDiv.style.display = 'none';
	
	function connect(url){
		webSocket = new WebSocket(url);
		webSocket.onopen = function(){
			console.log("onOpen");
			
			start.style.display = 'none';
			mesgDiv.style.display = 'block';
		};

		webSocket.onclose = function(){
			console.log("onClose");
			start.style.display = 'block';
			mesgDiv.style.display = 'none';
		};


		webSocket.onerror = function(){
			console.log("onError");
		};
		
	}
	
	
	
}