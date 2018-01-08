var TransformationForm = (function () {

    var transformations = [
        'abbreviation',
        'inverse',
        'upper',
        'lower',
        'capitalize',
        'latex'
    ];

    var DOM = (function () {
        var form = $('.transformation-form');
        var addBtn = form.find('.add-transformation');
        var transformationList = form.find('.transformation-list');

        return {
            form: form,
            addBtn: addBtn,
            transformationList: transformationList
        };
    })();


    var buildTransformation = function () {
        var $transformation = $('<li class="transformation"></li>');
        var $dropdown = $('<select class="option"></select>');
        var $removeBtn = $('<button class="remove"></button>');
        var name, capitalizedName;

        for (var i=0; i < transformations.length; i++) {
            name = transformations[i];
            capitalizedName = name.charAt(0).toUpperCase() + name.slice(1);
            $dropdown.append('<option value="' + name + '">' + capitalizedName + '</option>');
        }

        $transformation.append($dropdown);
        $transformation.append($removeBtn);
        $removeBtn.click(function() {
            $transformation.remove();
        });

        return $transformation;
    };

    var addTransformation = function (e) {
        if (e) {
            e.preventDefault();
        }

        var $transformation = buildTransformation();
        DOM.transformationList.append($transformation);
    };

    var bindEvents = function () {
        DOM.addBtn.click(addTransformation);
    };

    var init = function () {
        addTransformation();
        bindEvents();
    };

    return {
        init: init
    };

})();

$(document).ready(function () {
    TransformationForm.init();
});