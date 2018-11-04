let contractAddress;
let on = false;
let marker;
let count = 0;
let markersLat = ['53.09637672921633','53.086892540887376','53.07121843233004','53.082974548732864','53.08792353217958'];
let markersLng = ['8.819690817201945','8.819690817201945','8.770252340639445','8.775402181948039','8.735576742494914'];
let byteCode = '0x608060405234801561001057600080fd5b506040516105633803806105638339810160409081528151602080840151928401516000600881905560098190556006556004805460ff191690556002805433600160a060020a03199182161790915560018054909116600160a060020a0385161790556005849055909301805191939091610092916003919084019061009b565b50505050610136565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100dc57805160ff1916838001178555610109565b82800160010185558215610109579182015b828111156101095782518255916020019190600101906100ee565b50610115929150610119565b5090565b61013391905b80821115610115576000815560010161011f565b90565b61041e806101456000396000f3006080604052600436106100985763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166318b8c4db811461009d5780633dbf145c146100c45780635408cfae146100ed5780636f775b5e1461010257806373c2c83a14610119578063a46c058e14610131578063bdf53c3b14610146578063dc4c4c811461015b578063ecb9978d14610163575b600080fd5b3480156100a957600080fd5b506100b2610178565b60408051918252519081900360200190f35b3480156100d057600080fd5b506100d961017e565b604080519115158252519081900360200190f35b3480156100f957600080fd5b506100b2610187565b34801561010e57600080fd5b5061011761018d565b005b34801561012557600080fd5b506101176004356101a6565b34801561013d57600080fd5b5061011761020e565b34801561015257600080fd5b50610117610278565b6101176102e0565b34801561016f57600080fd5b50610117610353565b60065490565b60045460ff1690565b60085490565b600254600160a060020a031633146101a457600080fd5b565b60065460009082116101b757600080fd5b60065482036005540290506008548111156101d157506008545b6009805482019055600880548290039081905560068390551580156101fd575060045460ff1615156001145b1561020a5761020a6103a0565b5050565b600254600160a060020a0316331461022557600080fd5b60095460001061023457600080fd5b600254600954604051600160a060020a039092169181156108fc0291906000818181858888f19350505050158015610270573d6000803e3d6000fd5b506000600955565b60008054600160a060020a0316331461029057600080fd5b60045460ff1615156102a157600080fd5b600060085411156102ce575060008054600160a060020a03168152600a6020526040902060085481540181555b506004805460ff191690556000600855565b60055434116102ee57600080fd5b60045460ff16156102fe57600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff19163317908190556006546007556004805460ff191660011790553460085561034890600160a060020a03166103c2565b600880549091019055565b600061035e336103c2565b9050600081111561039d57604051339082156108fc029083906000818181858888f19350505050158015610396573d6000803e3d6000fd5b5060006008555b50565b60045460ff1615156103b157600080fd5b6004805460ff191690556000600855565b600160a060020a0381166000908152600a6020526040812080548210156103ec5780546000825591505b509190505600a165627a7a72305820984622daaef69fd2f85b2255a9b89bd6fd99b3c821a945feb74db16a59a3900d0029';
let abi = [
    {
        "constant": true,
        "inputs": [],
        "name": "current_measurement",
        "outputs": [
            {
                "name": "",
                "type": "uint256"
            }
        ],
        "payable": false,
        "stateMutability": "view",
        "type": "function"
    },
    {
        "constant": true,
        "inputs": [],
        "name": "status_lease",
        "outputs": [
            {
                "name": "",
                "type": "bool"
            }
        ],
        "payable": false,
        "stateMutability": "view",
        "type": "function"
    },
    {
        "constant": true,
        "inputs": [],
        "name": "current_balance",
        "outputs": [
            {
                "name": "",
                "type": "uint256"
            }
        ],
        "payable": false,
        "stateMutability": "view",
        "type": "function"
    },
    {
        "constant": false,
        "inputs": [],
        "name": "change_status",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
    },
    {
        "constant": false,
        "inputs": [
            {
                "name": "_measurement",
                "type": "uint256"
            }
        ],
        "name": "update_measurement",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
    },
    {
        "constant": false,
        "inputs": [],
        "name": "take_amount",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
    },
    {
        "constant": false,
        "inputs": [],
        "name": "stopLease",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
    },
    {
        "constant": false,
        "inputs": [],
        "name": "createLease",
        "outputs": [],
        "payable": true,
        "stateMutability": "payable",
        "type": "function"
    },
    {
        "constant": false,
        "inputs": [],
        "name": "take_deposit",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
    },
    {
        "inputs": [
            {
                "name": "_car",
                "type": "address"
            },
            {
                "name": "_price",
                "type": "uint256"
            },
            {
                "name": "_about",
                "type": "string"
            }
        ],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "constructor"
    }
];

let contractFace = web3.eth.contract(abi);

