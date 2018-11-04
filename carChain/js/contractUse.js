function deployContract(){
    let wallet = '0x6985B24eBe039aB7d28db3ac04C400aEf73EccbF';
    let about = 'ascdcsdsd';
    let _price = document.getElementsByClassName('input3')[0].value;
    let contractInstance = contractFace.new(wallet, _price, about, {from: web3.eth.accounts[0], data: byteCode, gas: 1000000}, function(err, contract) {
        if(!err) {
            if (typeof contract.address !== 'undefined') {
                console.log('Contract mined! address: ' + contract.address + ' transactionHash: ' + contract.transactionHash);
                contractAddress = contract.address;
                document.getElementById('carCard-none').id = 'carCard';
                document.getElementsByClassName('addCar')[0].className = 'addCar-none';
                document.getElementsByClassName('addCar-none')[1].className = 'addCar';
                document.getElementById('refresh-none').id = 'refresh';
                let urlJSON = 'http://10.90.23.72:8080/postCar';
                let params = '{\n' +
                    '"priceAllDays": 58.42149,\n' +
                    '"isChained": true,\n' +
                    '"manual": true,\n' +
                    '"websiteId": "ecob",\n' +
                    '"vehicle": "Hyundai i10",\n' +
                    '"location": {\n' +
                    '"pickUp": {\n' +
                    '"address": "Edinburgh Airport, NCP Scotpark, Eastfield Road, Newbridge, Edinburgh, EH28 8LS ",\n' +
                    '"distanceToSearchLocationInKm": 0.1760664228,\n' +
                    '"geoInfo": [\n' +
                    '  55.95079,\n' +
                    '  -3.36145\n' +
                    '],\n' +
                    '}\n' +
                    '},\n' +
                    '"url": "http://mapchain.000webhostapp.com/images/2.jpg"\n' +
                    '}';
                console.log(params)
                fetch(urlJSON,
                    {
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        method: 'POST',
                        body: params
                    })
                    .then((res1) => {
                        console.log('res1.token', res1);
                        res1.text().then((res2) => {
                            resolve(res2);
                            console.log('res2.token', res2);
                        });
                    });
            }
        }
    });
}

function onOff(){
    if(on){
        console.log('onOff', on);
        document.getElementById('onOff').innerText = 'ON';
        on = false;
    }else{
        console.log('onOff', on);
        document.getElementById('onOff').innerText = 'OFF';
        on = true;
    }
    let contractInstance = contractFace.at(contractAddress);
    contractInstance.change_status({from: web3.eth.accounts[0]}, function(error, result){
        console.log(result);
    });
}
