  
#include <iostream>
#include <vector>
using namespace std;
vector<vector<char>> board{{'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
                           {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                           {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
                           {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
                           {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                           {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                           {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};
vector<string> words = {"agra", "norway", "england", "gwalior"};

bool canPlaceHorizontal(string word, int x, int y)
{

    if (y == 0 && word.length() < board[0].size())
    {
        if (board[x][y + word.length()] != '+')
            return false;
    }
    else if ((y + word.length()) == board[0].size() && (word.length() != board[0].size()))
    {
        if (board[x][y - 1] != '+')
            return false;
    }
    else
    {
        if (((y - 1) >= 0 && board[x][y - 1] != '+') || ((y + word.length()) < board[0].size() && board[x][y + word.length()] != '+'))
            return false;
    }

    for (int i = 0; i < word.length(); i++)
    {
        if ((y + i) == board[0].size())
            return false;
        if (board[x][y + i] != '-' && board[x][y + i] != word[i])
            return false;
    }

    return true;
}

vector<bool> placeWordHorizontal(string word, int x, int y)
{
    vector<bool> loc(word.length(), false);
    for (int i = 0; i < word.length(); i++)
    {
        if (board[x][y + i] == '-')
        {
            loc[i] = true;
            board[x][y + i] = word[i];
        }
    }
    return loc;
}

void unPlaceWordHorizontal(string word, int x, int y, vector<bool> &loc)
{
    for (int i = 0; i < word.length(); i++)
        if (loc[i])
            board[x][y + i] = '-';
}

bool canPlaceVertical(string word, int x, int y)
{

    if (x == 0 && word.length() < board.size())
    {
        if (board[x + word.length()][y] != '+')
            return false;
    }
    else if ((x + word.length()) == board.size() && (word.length() != board.size()))
    {
        if (board[x - 1][y] != '+')
            return false;
    }
    else
    {
        if (((x - 1) >= 0 && board[x - 1][y] != '+') || ((x + word.length()) < board.size() && board[x + word.length()][y] != '+'))
            return false;
    }

    for (int i = 0; i < word.length(); i++)
    {
        if ((x + i) == board.size())
            return false;
        if (board[x + i][y] != '-' && board[x + i][y] != word[i])
            return false;
    }

    return true;
}

vector<bool> placeWordVertical(string word, int x, int y)
{
    vector<bool> loc(word.length(), false);
    for (int i = 0; i < word.length(); i++)
    {
        if (board[x + i][y] == '-')
        {
            loc[i] = true;
            board[x + i][y] = word[i];
        }
    }

    return loc;
}

void unPlaceWordVertical(string word, int x, int y, vector<bool> &loc)
{
    for (int i = 0; i < word.length(); i++)
        if (loc[i])
            board[x + i][y] = '-';
}

void crossWord_(int idx)
{
    if (idx == words.size())
    {
        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[0].size(); j++)
                cout << board[i][j] << " ";
            cout << endl;
        }

      
    }

    string word = words[idx];
    int count = 0;
    for (int i = 0; i < board.size(); i++)
    {
        for (int j = 0; j < board[0].size(); j++)
        {
            if (board[i][j] == '-' || board[i][j] == word[0])
            {
                if (canPlaceHorizontal(word, i, j))
                {
                    vector<bool> loc = placeWordHorizontal(word, i, j);
                     crossWord_(idx + 1);
                    unPlaceWordHorizontal(word, i, j, loc);
                }

                if (canPlaceVertical(word, i, j))
                {
                    vector<bool> loc = placeWordVertical(word, i, j);
                     crossWord_(idx + 1);
                    unPlaceWordVertical(word, i, j, loc);
                }
            }
        }
    }
    
}

void crossWord()
{
    crossWord_(0);
}


int main(){
    crossWord();
}