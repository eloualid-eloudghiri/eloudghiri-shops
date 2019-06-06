# Front-End EL-OUDGHIRI SHOPS

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.8.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.
(If problem with SCSS files : Run `npm rebuild node-sass` before serving)

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Project Structure
```
ui-eloudghiri-shops/ 
   ├──src/                                  # source files that will be compiled to javascript
   │   │
   │   ├──tslint.json                       # configuration file of TSLint
   │   │
   │   ├──tsconfig.app.json                 # config app for typescript
   │   │
   │   ├──tsconfig.spec.json                # config spec for typescript
   │   │
   │   ├──test.ts                           # test
   │   │
   │   ├──styles.scss                       # globally stylesheet
   │   │
   │   ├──index.html                        # application layout
   │   │
   │   ├──main.ts                           # entry file for our browser environment
   │   │
   │   ├──polyfills.ts                      # polyfills file
   │   │
   │   ├──favicon.ico                       # favicon 
   │   │
   │   ├──app/                              # application code - our working directory
   │   │   │
   │   │   ├──app.component.ts              # main application component
   │   │   │
   │   │   ├──app.component.html            # main application html file
   │   │   │
   │   │   ├──app.component.scss            # main application styles
   │   │   │
   │   │   ├──app.module.ts                 # main application module
   │   │   │
   │   │   ├──app.routing.ts                # application routes
   │   │   │
   │   │   ├──layout                        # componants of layout
   │   │   │
   │   │   ├──pages/                        # application pages components
   │   │   │        
   │   │   ├──shared/                       # shared modules folder
   │   │   │   │
   │   │   │   ├──models                    # Data models shared to all componants and services
   │   │   │   │
   │   │   │   ├──validatores               # shared input validatores
   │   │   │   │ 
   │   │   │   └──componants                # shared componants
   │   │   │
   │   │   └──services/                     # template glob components/directives/pipes/styles/utils
   │   │
   │   ├──environments/                     # environments
   │   │
   │   └──assets/                           # static assets are served here
   │       │
   │       ├──data/                         # mock of data
   │       ├──images/                       # images ressources
   │       └──fonts/                        # fonts ressources
   │ 
   ├──e2e/                                  # will be used for end-to-end tests 
   ├──angular.json                          # used for config of project specific settings
   ├──README.md                             # read me file
   ├──tsconfig.json                         # config for typescript
   ├──package.json                          # contains all dependencies used for prod and dev
   └──tslint.json                           # Angular-CLI includes an automatic Typescript-Linter, which can be configured with this file

```   

## The perfect mock backend to start with :

1) json-server installation :  Run `npm install -g json-server`
        
2) Create a JSON file with mock data in the mock folder ./src/assets/data/mock of the application, create a file with the extension .json. Inside you can add a set of data with several fields.

3) Run it : `json-server --watch exemple-json-responses.json --routes routes.json`
    Run the json-server in a terminal and launch the JSON file. 
    The option watch (shortcut: -w) allows to reload automatically the browser when the JSON file is modified.

4) Use the backend in your Angular application : Open your browser at the indicated URL (localhost:3000)


## Bootstrap :
   
install of the bootstrap css framework `npm install bootstrap@4.3.1 --save`
Add the Bootstrap file inside the angular.json file.


## JQuery :
   
install of JQuery javascript library `npm install jquery@3.4.1 --save`
Add the jquery file inside the angular.json file.


## Angular-Font-Awesome  :
   
install of font-awsome for icons `npm install --save font-awesome angular-font-awesome`
Add the font.awsome files (css & js files) inside the angular.json file.

