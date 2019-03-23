#define _GNU_SOURCE
#include "../include/valida.h"


//função que valida um id de um produto
int validaProduto(char * id, int i){
	int r = 0;
		if(!id[i])														//segue se o id[i] é \0 ou NULL
			if(isupper(id[0]) && isupper(id[1]))						//Se os dois primeiros carateres sao maiusculas 								
				if(('1'<=id[2]) && (id[2]<='9'))						//Se a 3ª posição é entre 1 e 9
					for(int n = 3; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}
	return r;
}

//função que valida um id de um cliente
int validaCliente(char * id, int i){
	int r = 0;
		if(!id[i])														//segue se o id[i] é \0 ou NULL
			if(isupper(id[0]))											//Se a primeiros carateres sao maiusculas 		
				if(('1'<=id[1]) && (id[1]<='5'))						//Se a 2ª posição é entre 1 e 5
					for(int n = 2; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}
	return r;
}

//Tokenize, devolve o i e preenche o array tokens
int toktok(char * linha, char** tokens) {
	char* tok = NULL;
	tok = strtok(linha, " ");
	int i = 0;

    while(tok){															// verificar a quantidade de sub strings na linha
    	if(i < 7)
    		tokens[i] = strdup(tok);
        tok = strtok(NULL," ");
        i++;
    } 
    return i;
}

//função que valida um id de uma venda
int validaVenda(char* linha, hash*** produtos, hash** clientes){
	int r = 0, i = 0;
	char** tokens = (char**)malloc(7*sizeof(char*));

	i = toktok(linha, tokens);

	if(i == 7)																// se tokens tiver 7 posicoes, estas devem ser testadas
		if( search_P(tokens[0], produtos) )
			if( atof(tokens[1]) <= 999.99 && atof(tokens[1]) >= 0.0 )		// atof(str) converte a str para float, pertence a string.h
				if( atoi(tokens[2]) <= 200 && atoi(tokens[2]) >= 1 )		// atoi(str) converte a str para int, pertence a string.h
					if( strcmp(tokens[3], "N") || strcmp(tokens[3], "P") )
						if( search_C(tokens[4], clientes) )
							if( atoi(tokens[5]) <= 12 && atoi(tokens[5]) >= 1 )
								if( atoi(tokens[6]) <= 3 && atoi(tokens[6]) >= 1 ) // validar a filial
									r = 1;
	return r;
}
