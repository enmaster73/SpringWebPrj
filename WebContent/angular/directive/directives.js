angular.module('todo').directive("myDirective", function() {
	  return {
		    restrict: 'E',
		    scope: {
		    		localauthor: "=localauthor",
		    		samename:"="
		    },
		    template: '<div>samename in directive scope : {{ samename }}</div>' +
		    				'<div>My name is {{ localauthor.name }}.</div>' +
		    				'<div>local scope : {{ localscope }}</div>',
		    link: function(scope) {
		      scope.localauthor.name = 'name changed to jungho from local directive';
		      scope.samename = "same name can be changed in directive";
		      scope.localscope = "local scope value";
		    }
		  }
		});

