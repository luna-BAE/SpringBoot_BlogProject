let index = {
	init: function() {
		$("#save").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});

	},

	save: function() {

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},

	deleteById: function() {

		var id = $("#id").text();

		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id,
			dataType: "json"
		}).done(function(resp) {
			alert("삭제가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},

	update: function() {


		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type: "PUT",
			url: "/api/board/" + id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글 수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},

	replySave: function() {

		let data = {
			content: $("#reply-content").val()
		};
		
		let boardId = $("#boardId").val();
		
		console.log(boardId);

		$.ajax({
			type: "POST",
			url: "/api/board/"+boardId+"/reply",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글 쓰기가 완료되었습니다.");
			location.href = "/board/"+boardId;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},
	
	replyDelete: function(boardId, replyId) {

		$.ajax({
			type: "DELETE",
			url: "/api/board/"+boardId+"/reply/"+replyId,
			dataType: "json"
		}).done(function(resp) {
			alert("댓글이 삭제되었습니다.");
			location.href = "/board/"+boardId;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	}

}

index.init();