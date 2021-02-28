let lotteriaPositions = [];
let lotteriaMarkers = [];

function getLotteriaLocations() {
    return $.ajax({
        url: "/map/lotteria.json",
        type: "POST",
        success: (res => {return res;})
    })
}

async function createLotteriaMarkers(){
    let lotteriaLocations = await getLotteriaLocations();
    saveInfo(lotteriaLocations.lotteria, lotteriaPositions, lotteriaMarkers, [5, 0]);
}

function setLotteriaMarkers(){
    momsTouch.className = '';
    burgerKing.className = '';
    lotteria.className = 'menu_selected';
    mcDonalds.className = '';

    clusterer.clear();
    clusterer.addMarkers(lotteriaMarkers);
}

createLotteriaMarkers();
