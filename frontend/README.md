# Getting Started with Create React App

## 1. Node.js 설치

[Window 설치 방법](https://kitty-geno.tistory.com/61)

[Mac 설치 방법](https://memostack.tistory.com/274)

## 2. yarn 설치

### Window

```
npm install -g yarn
```

### Mac

```
brew install yarn --without-node    # node 가 설치되어있다면
brew install yarn                   # node 가 없다면
```

or

```
npm install --global yarn
```

## 3. Dependency 설치

root directory에서

```
yarn
```

## 4. Dev Server Start

```
yarn start
```

## 5. eslint prettier 추가

vscode에 settings.json 수정

```json
{
    "editor.defaultFormatter": "esbenp.prettier-vscode",
    "[typescriptreact]": {
        "editor.defaultFormatter": "esbenp.prettier-vscode"
    },
    "[typescript]": {
        "editor.defaultFormatter": "esbenp.prettier-vscode"
    },
    "editor.formatOnSave": true
}
```

[참고](https://kimdabin.tistory.com/entry/Reactjs-ESLint%EC%99%80-Prettier%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-React-%ED%99%98%EA%B2%BD-%EC%84%A4%EC%A0%95-VSCode)
