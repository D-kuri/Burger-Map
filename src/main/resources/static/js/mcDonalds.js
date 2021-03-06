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
    mcDonaldsMarkers = [];
    let mcDonaldsLocations = await getMcDonaldsLocations();

    saveInfo(mcDonaldsLocations.mcDonalds, mcdonaldsPositions, mcDonaldsMarkers, [50, 0]);
}

function setMcDonaldsClusterer(){
    let mcDonaldsScore = document.getElementsByClassName('mcDonalds_score')

    clusterer.clear();
    for (let i=0 ; i<parseInt(mcDonaldsScore[0].innerHTML) ; i++){
        createMcDonaldsMarkers().then(() => {
            clusterer.addMarkers(mcDonaldsMarkers)
        });
    }
}

function setMcDonaldsMarkers(){
    momsTouch.className = '';
    burgerKing.className = '';
    lotteria.className = '';
    mcDonalds.className = 'menu_selected';

    setMcDonaldsClusterer();
}

function showMcDonaldsScore(){
    burgerKing_score.style.display = "none";
    momsTouch_score.style.display = "none";
    lotteria_score.style.display = "none";
    mcDonalds_score.style.display = "block";
}

function changeMcDonaldsScore(score){
    mcDonalds_five.className = '';
    mcDonalds_four.className = '';
    mcDonalds_three.className = '';
    mcDonalds_two.className = '';
    mcDonalds_one.className = '';

    score.className = 'mcDonalds_score';

    setMcDonaldsClusterer();
}
