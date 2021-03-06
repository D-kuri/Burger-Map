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
    lotteriaMarkers = [];
    let lotteriaLocations = await getLotteriaLocations();

    saveInfo(lotteriaLocations.lotteria, lotteriaPositions, lotteriaMarkers, [5, 0]);
}

function setLotteriaClusterer(){
    let lotteriaScore = document.getElementsByClassName('lotteria_score')

    clusterer.clear();
    for (let i=0 ; i<parseInt(lotteriaScore[0].innerHTML) ; i++){
        createLotteriaMarkers().then(() => {
            clusterer.addMarkers(lotteriaMarkers)
        });
    }
}

function setLotteriaMarkers(){
    momsTouch.className = '';
    burgerKing.className = '';
    lotteria.className = 'menu_selected';
    mcDonalds.className = '';

    setLotteriaClusterer();
}

function showLotteriaScore(){
    burgerKing_score.style.display = "none";
    momsTouch_score.style.display = "none";
    lotteria_score.style.display = "block";
    mcDonalds_score.style.display = "none";
}

function changeLotteriaScore(score){
    lotteria_five.className = '';
    lotteria_four.className = '';
    lotteria_three.className = '';
    lotteria_two.className = '';
    lotteria_one.className = '';

    score.className = 'lotteria_score';

    setLotteriaClusterer();
}

