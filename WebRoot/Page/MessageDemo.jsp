<%@ page language="java" import="java.util.*,com.MrCBBS.entities.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh" class="no-js">
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>消息中心</title>

    <script src="/MrCBBS/Scripts/accordion/modernizr.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/accordion/reset.css"/>
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/accordion/demo.css">
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/accordion/style.css">

</head>
<body>

<div class="container">

    <div class="accordion">
        <dl>
            <dt>
                <a href="#accordion1" aria-expanded="false" aria-controls="accordion1" class="accordion-title accordionTitle js-accordionTrigger">First Accordion heading</a>
            </dt>
            <dd class="accordion-content accordionItem is-collapsed" id="accordion1" aria-hidden="true">
                <p>Lorem ipsum dolor sit amet, consectetur Test adipiscing elit. Morbi eu interdum diam. Donec interdum porttitor risus non bibendum. Maecenas sollicitudin eros in quam imperdiet placerat. Cras justo purus, rhoncus nec lobortis ut, iaculis vel ipsum. Donec dignissim arcu nec elit faucibus condimentum. Donec facilisis consectetur enim sit amet varius. Pellentesque justo dui, sodales quis luctus a, iaculis eget mauris. </p>
                <p>Aliquam dapibus, ante quis fringilla feugiat, mauris risus condimentum massa, at elementum libero quam ac ligula. Pellentesque at rhoncus dolor. Duis porttitor nibh ut lobortis aliquam. Nullam eu dolor venenatis mauris placerat tristique eget id dolor. Quisque blandit adipiscing erat vitae dapibus. Nulla aliquam magna nec elementum tincidunt.</p>
            </dd>
        </dl>
    </div>

</div>

<script type="text/javascript">
    //uses classList, setAttribute, and querySelectorAll
    //if you want this to work in IE8/9 youll need to polyfill these
    (function(){
        var d = document,
                accordionToggles = d.querySelectorAll('.js-accordionTrigger'),
                setAria,
                setAccordionAria,
                switchAccordion,
                touchSupported = ('ontouchstart' in window),
                pointerSupported = ('pointerdown' in window);

        skipClickDelay = function(e){
            e.preventDefault();
            e.target.click();
        }

        setAriaAttr = function(el, ariaType, newProperty){
            el.setAttribute(ariaType, newProperty);
        };
        setAccordionAria = function(el1, el2, expanded){
            switch(expanded) {
                case "true":
                    setAriaAttr(el1, 'aria-expanded', 'true');
                    setAriaAttr(el2, 'aria-hidden', 'false');
                    break;
                case "false":
                    setAriaAttr(el1, 'aria-expanded', 'false');
                    setAriaAttr(el2, 'aria-hidden', 'true');
                    break;
                default:
                    break;
            }
        };
//function
        switchAccordion = function(e) {
            //console.log("triggered");
            e.preventDefault();
            var thisAnswer = e.target.parentNode.nextElementSibling;
            var thisQuestion = e.target;
            if(thisAnswer.classList.contains('is-collapsed')) {
                setAccordionAria(thisQuestion, thisAnswer, 'true');
            } else {
                setAccordionAria(thisQuestion, thisAnswer, 'false');
            }
            thisQuestion.classList.toggle('is-collapsed');
            thisQuestion.classList.toggle('is-expanded');
            thisAnswer.classList.toggle('is-collapsed');
            thisAnswer.classList.toggle('is-expanded');

            thisAnswer.classList.toggle('animateIn');
        };
        for (var i=0,len=accordionToggles.length; i<len; i++) {
            if(touchSupported) {
                accordionToggles[i].addEventListener('touchstart', skipClickDelay, false);
            }
            if(pointerSupported){
                accordionToggles[i].addEventListener('pointerdown', skipClickDelay, false);
            }
            accordionToggles[i].addEventListener('click', switchAccordion, false);
        }
    })();
</script>

</body>
</html>