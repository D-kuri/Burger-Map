let mcdonaldsPositions = [];
let mcDonaldsMarkers = [];

function getMcDonaldsLocations() {
    return $.ajax({
        url: "/map/mcDonalds.json",
        type: "POST",
        success: (res => {return res;})
    })
}

async function createMcDonaldsMarkers(){
    let mcDonaldsLocations = await getMcDonaldsLocations();
    saveInfo(mcDonaldsLocations.mcDonalds, mcdonaldsPositions, mcDonaldsMarkers, [50, 0]);

}

function setMcDonaldsMarkers(){
    momsTouch.className = '';
    burgerKing.className = '';
    lotteria.className = '';
    mcDonalds.className = 'menu_selected';

    clusterer.clear();
    clusterer.addMarkers(mcDonaldsMarkers);
}

createMcDonaldsMarkers();
