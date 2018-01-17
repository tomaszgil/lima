var TransformationForm = (function () {

    var transformations = [
        'abbreviation',
        'inverse',
        'upper',
        'lower',
        'capitalize',
        'latex',
        'numbers',
    ];

    var messages = {
        success: ['Result', ''],
        warning: ['Be careful.', 'Please fill out input form and specify transformations.'],
        failure: ['Ooops!', 'Something went wrong. Please try again.']
    };

    var cssClass = {
        success: 'alert-success',
        warning: 'alert-warning',
        failure: 'alert-danger'
    };

    var DOM = (function () {
        var form = $('.transformation-form');
        var mainInput = form.find('input[type="text"]');
        var addBtn = form.find('.add-transformation');
        var transformationList = form.find('.transformation-list');
        var submitBtn = form.find('input[type="submit"]');
        var resultWrapper = form.find('.alert');
        var resultMessage = resultWrapper.find('strong');
        var result = resultWrapper.find('.result');
        var resultCloseBtn = resultWrapper.find('.close');

        return {
            form: form,
            mainInput: mainInput,
            addBtn: addBtn,
            transformationList: transformationList,
            submitBtn: submitBtn,
            resultWrapper: resultWrapper,
            resultMessage: resultMessage,
            result: result,
            resultCloseBtn: resultCloseBtn
        };
    })();


    var buildTransformation = function () {
        var $transformation = $('<li class="transformation list-group-item"></li>');
        var $anchor = $('<button class="anchor"></button>')
        var $dropdown = $('<select class="option form-control"></select>');
        var $removeBtn = $('<button class="remove btn btn-danger"><span aria-hidden="true">&times;</span></button>');
        var name, capitalizedName;

        for (var i=0; i < transformations.length; i++) {
            name = transformations[i];
            capitalizedName = name.charAt(0).toUpperCase() + name.slice(1);
            $dropdown.append('<option value="' + name + '">' + capitalizedName + '</option>');
        }

        $transformation.append($anchor);
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

    var onSubmit = function (e) {
        e.preventDefault();
        var text = DOM.mainInput.val();
        var transformations = getCurrentTransformations().length;

        if (text && transformations) {
            sendRequest();
        } else {
            onWarning();
        }

        DOM.resultWrapper.show();
    };

    var sendRequest = function () {
        var data = {
            "text": DOM.mainInput.val(),
            "transforms": getCurrentTransformations()
        };

        $.ajax({
            type: 'POST',
            url: '/json',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: onSuccess,
            error: onFailure
        });
    };

    var getCurrentTransformations = function () {
        var transforms = [];

        DOM.transformationList.children().each(function() {
            var transform = $(this).find('select').val().toLowerCase();
            transforms.push(transform);
        });

        return transforms;
    };


    var onResultClose = function () {
        DOM.resultWrapper.hide();
        DOM.mainInput.val('');
        DOM.transformationList.empty();
        addTransformation();
    };

    var setResultStyle = function (state) {
        DOM.resultWrapper.removeClass(cssClass.success);
        DOM.resultWrapper.removeClass(cssClass.warning);
        DOM.resultWrapper.removeClass(cssClass.failure);
        DOM.resultWrapper.addClass(cssClass[state]);
    };

    var onFailure = function () {
        setResultStyle('failure');
        DOM.resultMessage.text(messages.failure[0]);
        DOM.result.text(messages.failure[1]);
    };

    var onWarning = function () {
        setResultStyle('warning');
        DOM.resultMessage.text(messages.warning[0]);
        DOM.result.text(messages.warning[1]);
    };

    var onSuccess = function (data) {
        setResultStyle('success');
        DOM.resultMessage.text(messages.success[0]);

        if (data.text) {
            DOM.result.text(data.text);
        } else {
            onFailure();
        }
    };

    var bindEvents = function () {
        DOM.addBtn.click(addTransformation);
        DOM.transformationList.sortable();
        DOM.transformationList.disableSelection();
        DOM.submitBtn.click(onSubmit);
        DOM.resultCloseBtn.unbind('click');
        DOM.resultCloseBtn.click(onResultClose);
    };

    var init = function () {
        DOM.resultWrapper.hide();
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