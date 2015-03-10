$(document).ready(function(){
	
	showAllSubjects();

	$(".header_menu").click(function(){
		emptyTable();
		hideAddForm();
	    var liText = $(this).text();
		$(this).addClass("active");
		removeClassActive(liText);
		console.log("liText:"+liText);
		
		
		if (liText == "Предметы"){
			showAllSubjects();
			
		}else if(liText == "Учителя"){
			showAllTeachers();
			
		}else if(liText == "Ученики"){
			showAllStudents();
			
		}else if(liText == "Классы"){
			
			showAllClasses();
		}
		
		
	});
	
	
	$(".dropdown-menu li").click(function(){
		removeClassActive();
		emptyTable();
		var liText = $(this).text();
		console.log("leText: "+liText);
		
		if(liText == "Добавить предмет"){
			console.log("trying to Добавить предмет ");
			
			showAddForm("#add_subject_Form");
		
		}
		
		else if(liText == "Добавить учителя"){
			console.log("trying to Добавить учителя");
			$('select[name=subject]').empty();
			$.get("allSubjects.json/", function(data) {
		        $.each(data, function(index, item) {
	            	console.log("subject name:"+item.name);
	            	$('select[name=subject]').append("<option>"+item.name+"</option>");
	            });
	        });
			showAddForm("#add_teacher_form");
		}
		
		else if(liText == "Добавить ученика"){
			console.log("trying to Добавить ученика");
			$('select[name=clas]').empty();
			$.get("allClasses.json/", function(data) {
		        $.each(data, function(index, item) {
	            	console.log("class name:"+item.name);
	            	$('select[name=clas]').append("<option>"+item.name+"</option>");
	            });
	        });
			showAddForm("#add_student_form");
		}
		
		else if (liText == "Добавить класс"){
			console.log("trying to Добавить класс")
			$('select[name=subjects]').empty();
			$.get("allSubjects.json/", function(data) {
		        $.each(data, function(index, item) {
	            	console.log("subject name:"+item.name);
	            	$('select[name=subjects]').append("<option>"+item.name+"</option>");
	            });
	        });
			showAddForm("#add_class_Form");
		}
		
	})
	
	
	
	function showAddForm(formId){
		hideAddForm();
		console.log("formId: "+formId);
		$(formId).css("display", "inline");
	};
	
    function hideAddForm(){
    	$("#form").children().each(function( index ) {
			 $(this).css("display", "none");
		});
    }
	
	function removeClassActive(text){
		$(".header_menu").each(function( index ) {
			  console.log( index + ": " + $( this ).text() );
			  if(text!= $(this).text()){
				  $(this).removeClass("active");		  
			  }
		});
	}
	
	function showAllSubjects(){
		console.log("getAllSubjects() method is called!");
		$.get("allSubjects.json/", function(data) {
            $(".table").append("<tr><th>ID</th><th>Название</th></tr>");
            $.each(data, function(index, item) {
            	$("#content").append("");;
                console.log("subject name:"+item.name)
            	$(".table").append("<tr><td>"+item.id+"</td><td>"+item.name+"</td></tr>");
            });
        });
	}
	
	function showAllTeachers(){
		console.log("showAllTeachers() method is called!");
		$.get("allTeachers.json/", function(data) {
            $(".table").append("<tr><th>ID</th><th>Имя</th> <th>Фамилия</th> <th>Предмет</th> </tr>");
            $.each(data, function(index, item) {
            	console.log("data: "+item);
            	$("#content").append("");;
                console.log("subject name:"+item.name)
            	$(".table").append("<tr><td>"+item.id+"</td> <td>"+item.name+"</td> <td>"+item.surname+"</td> <td>"+item.subject.name+"</td> </tr>");
            });
        });
	}
	
	function showAllStudents(){
		console.log("showAllStudents() method is called!");
		$.get("allStudents.json/", function(data) {
            $(".table").append("<tr><th>ID</th><th>Имя</th> <th>Фамилия</th> <th>Класс</th> </tr>");
            $.each(data, function(index, item) {
                console.log("subject name:"+item.name)
            	$(".table").append("<tr><td>"+item.id+"</td> <td>"+item.name+"</td> <td>"+item.surname+"</td> <td>"+item.clas.name+"</td> </tr>");
            });
        });
	}
	
	function showAllClasses(){
		console.log("showAllClasses() method is called!");
		$.get("allClasses.json/", function(data) {
            $(".table").append("<tr><th>ID</th><th>Название</th> </tr>");
            $.each(data, function(index, item) {
                console.log("subject name:"+item.name)
            	$(".table").append("<tr><td>"+item.id+"</td> <td>"+item.name+"</td> </tr>");
            });
        });
	}
	
	
	
	function emptyTable(){
		$(".table").empty();
	}
	
	
	
	
});