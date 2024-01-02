var mssql = require('mssql');
const config = {
user: 'BD19173',
password: '',
server: 'regulus.cotuca.unicamp.br',
database: 'BD19173'
};
mssql.connect(config)
.then(conexao => global.conexao = conexao)
.catch(erro => console.log(erro));
module.exports = mssql;

