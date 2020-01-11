# Incio
  - A aplicação deve ser inicia preferencialmente na porta 8080 do servidor ( localhost:8080 ) 
  tendo em vista que a aplicação web esta voltando todos seus links para esta url base
  
# Para o uso do Swagger (teste de WS)
>
 - acessar a url : http://localhost:8080/swagger-ui.html
 - Deve ser cadastrado o usuario (usando o sistema web ou o endpoint usuario-resource do proprio swagger)
 - Deve ser gerado um token JWT para esse usuario criado :
 
			-Usar um aplicativo como postman ou similar
				configuração da requisao para obtenção de token :
				tipo do metodo : POST 
				url : http://localhost:8080/oauth/token
				body : x-www-fortm-urleancoded
				keys :
					username : 'seu nome de usuario'
					senha : 'sua senha'
					grant_type : password      
  - O token sera devolvido e dever ser adiconado ao inicio a palavra 'bearer '  ( com um espaço entra a palavra e o token). Este token deve ser adicionado ao swagger para autorização das requisições.
