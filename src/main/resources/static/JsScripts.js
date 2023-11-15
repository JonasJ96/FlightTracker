
function showPopup(link) {
    var title = link.getAttribute('data-title');
    var airport = link.getAttribute('data-airport');
    var scheduled = link.getAttribute('data-scheduled');
    var actual = link.getAttribute('data-actual');
    var estimated = link.getAttribute('data-estimated');
    var content = 'Airport: ' + airport + '<br>Scheduled: ' + scheduled + '<br>Actual: ' + actual + '<br>Estimated: ' + estimated;
    document.getElementById('popup').innerHTML = '<h3>' + title + '</h3><p>' + content + '</p>';
    document.getElementById('popup').style.display = 'block';
    document.querySelector('.overlay').style.display = 'block';
}

function hidePopup() {
    document.getElementById('popup').style.display = 'none';
    document.querySelector('.overlay').style.display = 'none';
}

function loadMoreFlights() {

    var currentOffset = new URLSearchParams(window.location.search).get('offset');
    var currentairline = new URLSearchParams(window.location.search).get('airline');
    currentOffset = currentOffset ? parseInt(currentOffset) : 0;
    var newOffset = currentOffset + 100;
    var newUrl = window.location.origin + window.location.pathname + '?offset=' + newOffset + '&airline=' +currentairline;
    window.location.href = newUrl;
}

function refreshPage() {
    window.location.reload(true);
}

function applyFilters() {
    var airline = document.getElementById('airlineFilter').value;

    var newUrl = window.location.origin + window.location.pathname + '?airline=' + encodeURIComponent(airline);
    window.location.href = newUrl;
}