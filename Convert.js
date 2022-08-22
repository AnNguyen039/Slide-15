function feetToMeter(foot) {
    var foot = Number(document.getElementById('number').value);
    var optionType = document.getElementById('inputFunction1').value;
    if (optionType == "feetToMeter") {
        var meterConvert = 0.305 * foot;
    }
    if(meterConvert >= 0) {
        document.getElementById('exp').innerHTML = meterConvert + " Meter";
    }else{
        document.getElementById('exp').innerHTML = null;
    }
}
function meterToFeet(meter) {
    var meter = Number(document.getElementById('number').value);
    var optionType = document.getElementById('inputFunction1').value;
    if (optionType == "metersToFeet") {
        var feetTo = meter * 3;
    }
    if(feetTo >=0) {
        document.getElementById('exp1').innerHTML = feetTo + " Feet";
    }else {
        document.getElementById('exp1').innerHTML = null;
    }
}