
var map;

function loadMapScenario() {
    map = new Microsoft.Maps.Map(document.getElementById('map'), {
        center: new Microsoft.Maps.Location(0, 0),
        zoom: 2
    });
    addFlightPins();
}
function addFlightPins() {
    console.log(list)
    list.forEach((element) => {
        if (element.liveData) {
            var location = new Microsoft.Maps.Location(element.liveData.latitude, element.liveData.longitude);

            var img = new Image();
            img.src = '/airplane.png';
            img.onload = function () {
                var canvas = document.createElement('canvas');
                var rotationAngleRads = (element.liveData.direction-45)*Math.PI/180;
                canvas.width = 32
                canvas.height = 32
                var context = canvas.getContext('2d');

                context.translate(canvas.width / 2, canvas.height / 2);

                context.rotate(rotationAngleRads);

                context.drawImage(img, -img.width / 2, -img.height / 2);


                var pin = new Microsoft.Maps.Pushpin(location, {
                    icon: canvas.toDataURL(),
                    title: 'Flight ' + (element.number),
                    subTitle: 'Going to ' + element.arrival.airport,
                    anchor: new Microsoft.Maps.Point(0, 0),
                });

                Microsoft.Maps.Events.addHandler(pin, 'click', function (e) {
                    alert('Information about Aircraft\n' +
                        'Registration number: ' + element.aircraftData.registration + '\n' +
                        'Aircraft iata: ' + element.aircraftData.iata  + '\n' +
                        'Aircraft icao: ' + element.aircraftData.icao);
                });

                map.entities.push(pin);
            }
        }
    });
}
