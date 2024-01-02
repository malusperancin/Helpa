var mssql = require('mssql');
const config = {
};
mssql.connect(config)
.then(conexao => global.conexao = conexao)
.catch(erro => console.log(erro));
module.exports = mssql;

