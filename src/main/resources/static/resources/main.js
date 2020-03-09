(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/alert/alert.component.html":
/*!********************************************!*\
  !*** ./src/app/alert/alert.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"message\"\r\n     [ngClass]=\"{ 'alert': message, 'alert-success': message.type === 'success', 'alert-danger': message.type === 'error' }\">\r\n  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n  {{message.text}}\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/alert/alert.component.ts":
/*!******************************************!*\
  !*** ./src/app/alert/alert.component.ts ***!
  \******************************************/
/*! exports provided: AlertComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AlertComponent", function() { return AlertComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _alert_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./alert.service */ "./src/app/alert/alert.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AlertComponent = /** @class */ (function () {
    function AlertComponent(alertService) {
        this.alertService = alertService;
    }
    AlertComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.alertService.getMessage().subscribe(function (message) { _this.message = message; });
    };
    AlertComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-alert',
            template: __webpack_require__(/*! ./alert.component.html */ "./src/app/alert/alert.component.html")
        }),
        __metadata("design:paramtypes", [_alert_service__WEBPACK_IMPORTED_MODULE_1__["AlertService"]])
    ], AlertComponent);
    return AlertComponent;
}());



/***/ }),

/***/ "./src/app/alert/alert.service.ts":
/*!****************************************!*\
  !*** ./src/app/alert/alert.service.ts ***!
  \****************************************/
/*! exports provided: AlertService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AlertService", function() { return AlertService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AlertService = /** @class */ (function () {
    function AlertService(router) {
        var _this = this;
        this.router = router;
        this.subject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["Subject"]();
        this.keepAfterNavigationChange = false;
        // clear alert message on route change
        router.events.subscribe(function (event) {
            if (event instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationStart"]) {
                if (_this.keepAfterNavigationChange) {
                    // only keep for a single location change
                    _this.keepAfterNavigationChange = false;
                }
                else {
                    // clear alert
                    _this.subject.next();
                }
            }
        });
    }
    AlertService.prototype.success = function (message, keepAfterNavigationChange) {
        if (keepAfterNavigationChange === void 0) { keepAfterNavigationChange = false; }
        this.keepAfterNavigationChange = keepAfterNavigationChange;
        this.subject.next({ type: 'success', text: message });
    };
    AlertService.prototype.error = function (message, keepAfterNavigationChange) {
        if (keepAfterNavigationChange === void 0) { keepAfterNavigationChange = false; }
        this.keepAfterNavigationChange = keepAfterNavigationChange;
        this.subject.next({ type: 'error', text: message });
    };
    AlertService.prototype.getMessage = function () {
        return this.subject.asObservable();
    };
    AlertService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
    ], AlertService);
    return AlertService;
}());



/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _projects_projects_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./projects/projects.component */ "./src/app/projects/projects.component.ts");
/* harmony import */ var _auth_guard__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./auth.guard */ "./src/app/auth.guard.ts");
/* harmony import */ var _project_details_project_details_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./project-details/project-details.component */ "./src/app/project-details/project-details.component.ts");
/* harmony import */ var _pattern_wizard_pattern_wizard_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./pattern-wizard/pattern-wizard.component */ "./src/app/pattern-wizard/pattern-wizard.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    { path: '', component: _login_login_component__WEBPACK_IMPORTED_MODULE_2__["LoginComponent"] },
    { path: 'projects', component: _projects_projects_component__WEBPACK_IMPORTED_MODULE_3__["ProjectsComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_4__["AuthGuard"]] },
    { path: 'projects/:projectId', component: _project_details_project_details_component__WEBPACK_IMPORTED_MODULE_5__["ProjectDetailsComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_4__["AuthGuard"]] },
    { path: 'projects/:projectId/addReq', component: _pattern_wizard_pattern_wizard_component__WEBPACK_IMPORTED_MODULE_6__["PatternWizardComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_4__["AuthGuard"]] },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".container-fluid {\r\n  padding: 4em 2em;\r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxnQkFBZ0I7QUFDbEIiLCJmaWxlIjoic3JjL2FwcC9hcHAuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5jb250YWluZXItZmx1aWQge1xyXG4gIHBhZGRpbmc6IDRlbSAyZW07XHJcbn1cclxuXHJcblxyXG4iXX0= */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!-- navbar -->\r\n<nav class=\"navbar navbar-default navbar-dark bg-dark\">\r\n  <div class=\"container\">\r\n\r\n    <a class=\"navbar-brand\" routerLink=\"/\">SPS2PLC</a>\r\n    <ul class=\"navbar-nav navbar-right\" *ngIf=\"authenticationService.isAuthenticated()\">\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\" (click)=\"logout()\" routerLink=\"/\" >Logout</a>\r\n      </li>\r\n    </ul>\r\n  </div>\r\n</nav>\r\n\r\n<!-- main app container -->\r\n<div class=\"container-fluid\">\r\n\r\n  <div class=\"container\">\r\n      <app-alert></app-alert>\r\n\r\n      <router-outlet></router-outlet>\r\n  </div>\r\n</div>\r\n\r\n<footer>\r\n  <div class=\"container\">\r\n    <div class=\"hline\"></div>\r\n    <p class=\"small\">\r\n      Copyright © 2020 Maps | All Rights Reserved\r\n    </p>\r\n  </div>\r\n\r\n</footer>\r\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = /** @class */ (function () {
    function AppComponent(authenticationService) {
        this.authenticationService = authenticationService;
    }
    AppComponent.prototype.logout = function () {
        this.authenticationService.logout();
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/release/index.js");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(_swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5__);
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/index.js");
/* harmony import */ var _material_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../material-module */ "./src/material-module.ts");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _projects_projects_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./projects/projects.component */ "./src/app/projects/projects.component.ts");
/* harmony import */ var _alert_alert_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./alert/alert.component */ "./src/app/alert/alert.component.ts");
/* harmony import */ var _project_dialog_project_dialog_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./project-dialog/project-dialog.component */ "./src/app/project-dialog/project-dialog.component.ts");
/* harmony import */ var _project_details_project_details_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./project-details/project-details.component */ "./src/app/project-details/project-details.component.ts");
/* harmony import */ var _requirement_details_requirement_details_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./requirement-details/requirement-details.component */ "./src/app/requirement-details/requirement-details.component.ts");
/* harmony import */ var _project_details_requirements_tab_requirements_tab_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./project-details/requirements-tab/requirements-tab.component */ "./src/app/project-details/requirements-tab/requirements-tab.component.ts");
/* harmony import */ var _project_details_tasks_tab_tasks_tab_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./project-details/tasks-tab/tasks-tab.component */ "./src/app/project-details/tasks-tab/tasks-tab.component.ts");
/* harmony import */ var _projects_delete_project_modal_delete_project_modal_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./projects/delete-project-modal/delete-project-modal.component */ "./src/app/projects/delete-project-modal/delete-project-modal.component.ts");
/* harmony import */ var _pattern_wizard_expression_wizard_property_expression_wizard_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./pattern-wizard/expression-wizard/property-expression-wizard.component */ "./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.ts");
/* harmony import */ var _pattern_wizard_pattern_wizard_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./pattern-wizard/pattern-wizard.component */ "./src/app/pattern-wizard/pattern-wizard.component.ts");
/* harmony import */ var _pattern_wizard_expression_wizard_scope_expression_wizard_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./pattern-wizard/expression-wizard/scope-expression-wizard.component */ "./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.ts");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./alert/alert.service */ "./src/app/alert/alert.service.ts");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./services/project.service */ "./src/app/services/project.service.ts");
/* harmony import */ var _services_requirement_service__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./services/requirement.service */ "./src/app/services/requirement.service.ts");
/* harmony import */ var _services_task_service__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./services/task.service */ "./src/app/services/task.service.ts");
/* harmony import */ var _auth_guard__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./auth.guard */ "./src/app/auth.guard.ts");
/* harmony import */ var _jwt_interceptor_js__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! ./jwt.interceptor.js */ "./src/app/jwt.interceptor.js.ts");
/* harmony import */ var _project_details_io_table_tab_io_table_tab_component__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! ./project-details/io-table-tab/io-table-tab.component */ "./src/app/project-details/io-table-tab/io-table-tab.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
// Modules









// Components













// Services





// Guards

// Http Interceptor


var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_10__["LoginComponent"],
                _alert_alert_component__WEBPACK_IMPORTED_MODULE_12__["AlertComponent"],
                _projects_projects_component__WEBPACK_IMPORTED_MODULE_11__["ProjectsComponent"],
                _project_dialog_project_dialog_component__WEBPACK_IMPORTED_MODULE_13__["ProjectDialogComponent"],
                _project_details_project_details_component__WEBPACK_IMPORTED_MODULE_14__["ProjectDetailsComponent"],
                _requirement_details_requirement_details_component__WEBPACK_IMPORTED_MODULE_15__["RequirementDetailsComponent"],
                _project_details_requirements_tab_requirements_tab_component__WEBPACK_IMPORTED_MODULE_16__["RequirementsTabComponent"],
                _project_details_tasks_tab_tasks_tab_component__WEBPACK_IMPORTED_MODULE_17__["TasksTabComponent"],
                _pattern_wizard_pattern_wizard_component__WEBPACK_IMPORTED_MODULE_20__["PatternWizardComponent"],
                _pattern_wizard_expression_wizard_property_expression_wizard_component__WEBPACK_IMPORTED_MODULE_19__["PropertyExpressionWizardComponent"],
                _projects_delete_project_modal_delete_project_modal_component__WEBPACK_IMPORTED_MODULE_18__["DeleteProjectModalComponent"],
                _pattern_wizard_expression_wizard_scope_expression_wizard_component__WEBPACK_IMPORTED_MODULE_21__["ScopeExpressionWizardComponent"],
                _project_details_io_table_tab_io_table_tab_component__WEBPACK_IMPORTED_MODULE_29__["IoTableTabComponent"],
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClientModule"],
                _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5__["NgxDatatableModule"],
                _material_module__WEBPACK_IMPORTED_MODULE_7__["MaterialModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_8__["BrowserAnimationsModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_6__["NgbModule"].forRoot(),
            ],
            providers: [
                _services_authentication_service__WEBPACK_IMPORTED_MODULE_22__["AuthenticationService"],
                _auth_guard__WEBPACK_IMPORTED_MODULE_27__["AuthGuard"],
                _alert_alert_service__WEBPACK_IMPORTED_MODULE_23__["AlertService"],
                {
                    provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HTTP_INTERCEPTORS"],
                    useClass: _jwt_interceptor_js__WEBPACK_IMPORTED_MODULE_28__["JwtInterceptor"],
                    multi: true
                },
                _services_project_service__WEBPACK_IMPORTED_MODULE_24__["ProjectService"],
                _services_requirement_service__WEBPACK_IMPORTED_MODULE_25__["RequirementService"],
                _services_task_service__WEBPACK_IMPORTED_MODULE_26__["TaskService"],
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/auth.guard.ts":
/*!*******************************!*\
  !*** ./src/app/auth.guard.ts ***!
  \*******************************/
/*! exports provided: AuthGuard */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthGuard", function() { return AuthGuard; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AuthGuard = /** @class */ (function () {
    function AuthGuard(router, autheticationService) {
        this.router = router;
        this.autheticationService = autheticationService;
    }
    AuthGuard.prototype.canActivate = function (next, state) {
        if (this.autheticationService.isAuthenticated()) {
            return true;
        }
        this.router.navigate(['/']);
        return false;
    };
    AuthGuard = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]])
    ], AuthGuard);
    return AuthGuard;
}());



/***/ }),

/***/ "./src/app/jwt.interceptor.js.ts":
/*!***************************************!*\
  !*** ./src/app/jwt.interceptor.js.ts ***!
  \***************************************/
/*! exports provided: JwtInterceptor */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "JwtInterceptor", function() { return JwtInterceptor; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var JwtInterceptor = /** @class */ (function () {
    function JwtInterceptor() {
    }
    JwtInterceptor.prototype.intercept = function (request, next) {
        // add authorization header with jwt token if available
        var authorization = localStorage.getItem(_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["CURRENT_USER"]);
        if (authorization == null) {
            authorization = '';
        }
        request = request.clone({
            setHeaders: {
                Authorization: authorization
            }
        });
        return next.handle(request);
    };
    JwtInterceptor = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])()
    ], JwtInterceptor);
    return JwtInterceptor;
}());



/***/ }),

/***/ "./src/app/login/login.component.css":
/*!*******************************************!*\
  !*** ./src/app/login/login.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2xvZ2luL2xvZ2luLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-6 col-md-offset-3\">\r\n  <h2>Login</h2>\r\n  <form name=\"form\" (ngSubmit)=\"f.form.valid && login()\" #f=\"ngForm\" novalidate>\r\n    <div class=\"form-group\" [ngClass]=\"{ 'has-error': f.submitted && !username.valid }\">\r\n      <label for=\"username\">Username</label>\r\n      <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" [(ngModel)]=\"model.username\" #username=\"ngModel\" required />\r\n      <div *ngIf=\"f.submitted && !username.valid\" class=\"help-block\">Username is required</div>\r\n    </div>\r\n    <div class=\"form-group\" [ngClass]=\"{ 'has-error': f.submitted && !password.valid }\">\r\n      <label for=\"password\">Password</label>\r\n      <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" [(ngModel)]=\"model.password\" #password=\"ngModel\" required />\r\n      <div *ngIf=\"f.submitted && !password.valid\" class=\"help-block\">Password is required</div>\r\n    </div>\r\n    <div class=\"form-group\">\r\n      <button [disabled]=\"loading\" class=\"btn btn-primary\">\r\n        <i *ngIf=\"loading\" class='fa fa-spinner fa-spin'></i>Login\r\n      </button>\r\n<!--      <a [routerLink]=\"['/register']\" disabled=\"true\"  class=\"btn btn-link\">Register</a>-->\r\n    </div>\r\n  </form>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../alert/alert.service */ "./src/app/alert/alert.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LoginComponent = /** @class */ (function () {
    function LoginComponent(route, router, authenticationService, alertService) {
        this.route = route;
        this.router = router;
        this.authenticationService = authenticationService;
        this.alertService = alertService;
        this.model = {};
        this.loading = false;
    }
    LoginComponent.prototype.ngOnInit = function () {
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/projects';
        if (this.authenticationService.isAuthenticated()) {
            this.router.navigate([this.returnUrl]);
        }
    };
    LoginComponent.prototype.login = function () {
        var _this = this;
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(function (data) {
            _this.alertService.success('Login succesful!');
            _this.loading = false;
            _this.router.navigate([_this.returnUrl]);
        }, function (error) {
            console.log(error);
            _this.alertService.error(error.message);
            _this.loading = false;
        });
    };
    LoginComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"],
            _services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"],
            _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__["AlertService"]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/models/io.ts":
/*!******************************!*\
  !*** ./src/app/models/io.ts ***!
  \******************************/
/*! exports provided: IOMap */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IOMap", function() { return IOMap; });
var IOMap = /** @class */ (function () {
    function IOMap(ioMap) {
        this.id = ioMap.id;
        this.projectId = ioMap.projectId;
        this.IOName = ioMap.IOName;
        this.IONumber = ioMap.IONumber;
    }
    return IOMap;
}());



/***/ }),

/***/ "./src/app/models/project.ts":
/*!***********************************!*\
  !*** ./src/app/models/project.ts ***!
  \***********************************/
/*! exports provided: Project */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Project", function() { return Project; });
var Project = /** @class */ (function () {
    function Project(id, name, description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    return Project;
}());



/***/ }),

/***/ "./src/app/models/requirement.ts":
/*!***************************************!*\
  !*** ./src/app/models/requirement.ts ***!
  \***************************************/
/*! exports provided: ReqState, Requirement */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ReqState", function() { return ReqState; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Requirement", function() { return Requirement; });
var ReqState;
(function (ReqState) {
    ReqState["COMPLIANT"] = "COMPLIANT";
    ReqState["ERROR"] = "ERROR";
    ReqState["NOT_CHECKED"] = "NOT_CHECKED";
})(ReqState || (ReqState = {}));
var Requirement = /** @class */ (function () {
    function Requirement() {
    }
    Requirement.prototype.create = function (req) {
        this.id = req.id;
        this.text = req.text;
        this.project = req.project;
        this.errorDescription = req.errorDescription;
        this.state = req.state;
        this.disabled = req.disabled;
        return this;
    };
    Object.defineProperty(Requirement.prototype, "compliant", {
        get: function () { return this.state === ReqState.COMPLIANT; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Requirement.prototype, "error", {
        get: function () { return this.state === ReqState.ERROR; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Requirement.prototype, "notChecked", {
        get: function () { return this.state === ReqState.NOT_CHECKED; },
        enumerable: true,
        configurable: true
    });
    return Requirement;
}());



/***/ }),

/***/ "./src/app/models/specification.ts":
/*!*****************************************!*\
  !*** ./src/app/models/specification.ts ***!
  \*****************************************/
/*! exports provided: Scope, Endpoint, Delay, Property, Index */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Scope", function() { return Scope; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Endpoint", function() { return Endpoint; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Delay", function() { return Delay; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Property", function() { return Property; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Index", function() { return Index; });
var Scope = /** @class */ (function () {
    function Scope(name, template, description, endPointsNum, candidateDelay) {
        this.name = name;
        this.template = template;
        this.description = description;
        this.candidateDelay = candidateDelay;
        this.text = this.template;
        this.endPointsNum = endPointsNum;
        this.leftEndpoint = null;
        this.rightEndpoint = null;
    }
    Scope.prototype.getAllEndPoints = function () {
        var endPointsList = new Array();
        function tempFunc(_endPoint) {
            if (_endPoint === null) {
                return;
            }
            if (_endPoint.andGroup !== null) {
                tempFunc(_endPoint.andGroup[0]);
                tempFunc(_endPoint.andGroup[1]);
                return;
            }
            if (_endPoint.orGroup !== null) {
                tempFunc(_endPoint.orGroup[0]);
                tempFunc(_endPoint.orGroup[1]);
                return;
            }
            endPointsList.push(_endPoint);
        }
        tempFunc(this.leftEndpoint);
        tempFunc(this.rightEndpoint);
        return endPointsList;
    };
    return Scope;
}());

var Endpoint = /** @class */ (function () {
    function Endpoint(name, isNot, andGroup, orGroup) {
        this.name = name;
        this.isNot = isNot;
        this.andGroup = andGroup;
        this.orGroup = orGroup;
    }
    Endpoint.prototype.toText = function (index) {
        var notStr = this.isNot ? 'not ' : '';
        if (this.andGroup !== null) {
            return notStr + ("(" + this.andGroup[0].toText(index) + " and " + this.andGroup[1].toText(index) + ")");
        }
        if (this.orGroup !== null) {
            return notStr + ("(" + this.orGroup[0].toText(index) + " or " + this.orGroup[1].toText(index) + ")");
        }
        index.value++;
        return this.name === '' ? notStr + ("{" + index.value + "}") : notStr + this.name;
    };
    return Endpoint;
}());

var Delay = /** @class */ (function () {
    function Delay(name, template, varNum, description) {
        this.name = name;
        this.template = template;
        this.description = description;
        this.varNum = varNum;
        this.text = this.template;
        this.vars = new Array(varNum).fill('');
    }
    return Delay;
}());

var Property = /** @class */ (function () {
    function Property(name, template, targetNum, description) {
        this.name = name;
        this.template = template;
        this.targetNum = targetNum;
        this.description = description;
        this.text = template;
        this.targets = new Array(targetNum).fill('');
    }
    Property.prototype.copy = function () {
        return new Property(this.name, this.template, this.targetNum, this.description);
    };
    return Property;
}());

var Index = /** @class */ (function () {
    function Index(value) {
        this.value = value;
    }
    return Index;
}());



/***/ }),

/***/ "./src/app/models/task.ts":
/*!********************************!*\
  !*** ./src/app/models/task.ts ***!
  \********************************/
/*! exports provided: TaskStatus, Task */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TaskStatus", function() { return TaskStatus; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Task", function() { return Task; });
var TaskStatus;
(function (TaskStatus) {
    TaskStatus["PRIORITY"] = "PRIORITY";
    TaskStatus["GENERATE"] = "GENERATE";
    TaskStatus["CIRCULAR"] = "CIRCULAR";
})(TaskStatus || (TaskStatus = {}));
var Task = /** @class */ (function () {
    function Task(task) {
        this.projectId = task.projectId;
        this.description = task.description;
        this.status = task.status;
        this.timestamp = task.timestamp;
        this.priorityArray = task.priorityArray;
        this.circularDependencyArray = task.circularDependencyArray;
        this.code = task.code;
        this.requirements = task.requirements;
    }
    Object.defineProperty(Task.prototype, "priority", {
        get: function () { return this.status === TaskStatus.PRIORITY; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Task.prototype, "generate", {
        get: function () { return this.status === TaskStatus.GENERATE; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Task.prototype, "circular", {
        get: function () { return this.status === TaskStatus.CIRCULAR; },
        enumerable: true,
        configurable: true
    });
    return Task;
}());



/***/ }),

/***/ "./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.css":
/*!*******************************************************************************************!*\
  !*** ./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.css ***!
  \*******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BhdHRlcm4td2l6YXJkL2V4cHJlc3Npb24td2l6YXJkL3Byb3BlcnR5LWV4cHJlc3Npb24td2l6YXJkLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.html":
/*!********************************************************************************************!*\
  !*** ./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.html ***!
  \********************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"pl-2\" style=\"border-left: 1px solid #eeeeee; height: 100%;\">\r\n  <p>{{_property.text}}</p>\r\n  <p *ngFor=\"let property of _additionalProperties\">\r\n    {{ 'and ' + property.text }}\r\n  </p>\r\n\r\n  <div [formGroup]=\"propertyForm\">\r\n    <div formArrayName=\"propertyFormArray\">\r\n        <fieldset class=\"pt-2\" *ngFor=\"let control of propertyFormArray.controls; let i = index; trackBy: customTrackBy;\">\r\n          <label class=\"form-control-label\" [attr.for]=\"'propertyExpr' + i\">Expr {{i + 1}}</label>\r\n          <input class=\"form-control\" [formControlName]=\"i\" [matAutocomplete]=\"auto\" [attr.id]=\"'propertyExpr' + i\"  [ngClass]=\"{'is-valid': control.valid, 'is-invalid': !(control.valid || control.pristine)}\">\r\n          <mat-autocomplete #auto=\"matAutocomplete\">\r\n            <mat-option *ngFor=\"let option of filteredOptions[i] | async\" [value]=\"option\">\r\n              {{option}}\r\n            </mat-option>\r\n          </mat-autocomplete>\r\n        </fieldset>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.ts":
/*!******************************************************************************************!*\
  !*** ./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.ts ***!
  \******************************************************************************************/
/*! exports provided: PropertyExpressionWizardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PropertyExpressionWizardComponent", function() { return PropertyExpressionWizardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_specification__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../models/specification */ "./src/app/models/specification.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _services_requirement_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../services/requirement.service */ "./src/app/services/requirement.service.ts");
/* harmony import */ var _services_io_table_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../services/io-table.service */ "./src/app/services/io-table.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var PropertyExpressionWizardComponent = /** @class */ (function () {
    function PropertyExpressionWizardComponent(fb, reqService, ioTableService) {
        this.fb = fb;
        this.reqService = reqService;
        this.ioTableService = ioTableService;
        this._property = null;
        this._additionalProperties = new Array();
        this.allProperties = new Array();
        this.filteredOptions = [];
        this.propertyForm = this.fb.group({
            propertyFormArray: this.fb.array([])
        });
        this.propertyChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.propertyValidChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
    }
    PropertyExpressionWizardComponent.prototype.ngOnInit = function () {
    };
    PropertyExpressionWizardComponent.prototype.filter = function (value) {
        return this.ioTableService.getItems().filter(function (item) { return item.includes(value); });
    };
    Object.defineProperty(PropertyExpressionWizardComponent.prototype, "propertyFormArray", {
        get: function () {
            return this.propertyForm.get('propertyFormArray');
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PropertyExpressionWizardComponent.prototype, "property", {
        get: function () {
            return this._property;
        },
        set: function (property) {
            var _this = this;
            this._property = property;
            this._property.targets = new Array(property.targetNum).fill('');
            while (this.propertyFormArray.length > 0) {
                this.propertyFormArray.removeAt(this.propertyFormArray.length - 1);
            }
            this.filteredOptions.splice(0, this.filteredOptions.length);
            this._property.targets.forEach(function (value, index) {
                var control = _this.fb.control(value, [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].pattern(/^\S+$/)]);
                _this.filteredOptions.push(control.valueChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (changedValue) {
                    _this._property.targets[index] = changedValue;
                    _this.update();
                }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["startWith"])(''), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (changedValue) { return _this.filter(changedValue); })));
                _this.propertyFormArray.controls.push(control);
            });
            this.update();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PropertyExpressionWizardComponent.prototype, "additionalProperties", {
        get: function () {
            return this._additionalProperties;
        },
        set: function (additionalProperties) {
            var _this = this;
            this._additionalProperties = additionalProperties;
            if (this.additionalProperties.length !== 0) {
                var newProperty_1 = this._additionalProperties[this._additionalProperties.length - 1];
                newProperty_1.targets.forEach(function (value, index) {
                    var control = _this.fb.control(value, [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].pattern(/^\S+$/)]);
                    _this.filteredOptions.push(control.valueChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (changedValue) {
                        newProperty_1.targets[index] = changedValue;
                        _this.update();
                    }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["startWith"])(''), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (changedValue) { return _this.filter(changedValue); })));
                    _this.propertyFormArray.controls.push(control);
                });
                this.update();
            }
        },
        enumerable: true,
        configurable: true
    });
    PropertyExpressionWizardComponent.prototype.update = function () {
        this.allProperties = [this._property].concat(this._additionalProperties);
        var properties = this.allProperties;
        var counter = 0;
        var _loop_1 = function (index) {
            this_1.allProperties[index].text = this_1.allProperties[index].template.replace(/{(\d+)}/g, function (match, number) {
                counter++;
                return properties[index].targets[parseInt(number, 10) - 1] === '' ? "{" + counter + "}" : properties[index].targets[parseInt(number, 10) - 1];
            });
        };
        var this_1 = this;
        for (var index = 0; index < this.allProperties.length; index++) {
            _loop_1(index);
        }
        this.propertyValidChanged.emit(this.propertyFormArray.controls.every(function (control) { return control.valid; }));
        this.propertyChanged.emit();
    };
    PropertyExpressionWizardComponent.prototype.customTrackBy = function (index, obj) {
        return obj;
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], PropertyExpressionWizardComponent.prototype, "projectId", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], PropertyExpressionWizardComponent.prototype, "propertyChanged", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], PropertyExpressionWizardComponent.prototype, "propertyValidChanged", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", _models_specification__WEBPACK_IMPORTED_MODULE_1__["Property"]),
        __metadata("design:paramtypes", [_models_specification__WEBPACK_IMPORTED_MODULE_1__["Property"]])
    ], PropertyExpressionWizardComponent.prototype, "property", null);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Array),
        __metadata("design:paramtypes", [Array])
    ], PropertyExpressionWizardComponent.prototype, "additionalProperties", null);
    PropertyExpressionWizardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-property-expression-wizard',
            template: __webpack_require__(/*! ./property-expression-wizard.component.html */ "./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.html"),
            styles: [__webpack_require__(/*! ./property-expression-wizard.component.css */ "./src/app/pattern-wizard/expression-wizard/property-expression-wizard.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _services_requirement_service__WEBPACK_IMPORTED_MODULE_4__["RequirementService"],
            _services_io_table_service__WEBPACK_IMPORTED_MODULE_5__["IoTableService"]])
    ], PropertyExpressionWizardComponent);
    return PropertyExpressionWizardComponent;
}());



/***/ }),

/***/ "./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.css":
/*!****************************************************************************************!*\
  !*** ./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.css ***!
  \****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BhdHRlcm4td2l6YXJkL2V4cHJlc3Npb24td2l6YXJkL3Njb3BlLWV4cHJlc3Npb24td2l6YXJkLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.html":
/*!*****************************************************************************************!*\
  !*** ./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.html ***!
  \*****************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"pl-2\" style=\"border-left: 1px solid #eeeeee; height: 100%;\">\n  <p>{{_scope.text + (_delay === null ? '' : ', ' + _delay.text)}}</p>\n  <div [formGroup]=\"scopeForm\">\n    <div formArrayName=\"scopeFormArray\">\n      <fieldset class=\"pt-2\" *ngFor=\"let control of scopeFormArray.controls; let i = index\">\n        <label class=\"form-control-label\" [attr.for]=\"'scopeExpr' + i\">Expr {{i + 1}}</label>\n        <div class=\"input-group\">\n          <input class=\"form-control\" [attr.id]=\"'scopeExpr' + i\" [matAutocomplete]=\"auto\" [formControlName]=\"i\"  [ngClass]=\"{'is-valid': control.valid, 'is-invalid': !(control.valid || control.pristine)}\">\n          <mat-autocomplete #auto=\"matAutocomplete\">\n            <mat-option *ngFor=\"let option of filteredOptions[i] | async\" [value]=\"option\">\n              {{option}}\n            </mat-option>\n          </mat-autocomplete>\n          <div class=\"input-group-append\">\n            <button class=\"btn btn-outline-secondary dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><i class=\"fa fa-plus\"></i></button>\n            <ul class=\"dropdown-menu\">\n              <li class=\"dropdown-item\" (click)=\"add(_scope.getAllEndPoints()[i],'and', i)\">and</li>\n              <li class=\"dropdown-item\" (click)=\"add(_scope.getAllEndPoints()[i], 'or', i)\">or</li>\n              <div role=\"separator\" class=\"dropdown-divider\"></div>\n              <li class=\"dropdown-item\" (click)=\"not(_scope.getAllEndPoints()[i])\">not</li>\n            </ul>\n          </div>\n        </div>\n      </fieldset>\n    </div>\n  </div>\n\n  <div *ngIf=\"_delay !== null\" class=\"mt-3\" style=\"border-top: 1px solid #eeeeee;\">\n    <div [formGroup]=\"delayForm\">\n      <div formArrayName=\"delayFormArray\">\n        <fieldset class=\"pt-2\" *ngFor=\"let control of delayFormArray.controls; let i = index;\">\n          <label class=\"form-control-label\" [attr.for]=\"'delayExpr' + i\">Expr t{{i + 1}}</label>\n          <input class=\"form-control\" [attr.id]=\"'delayExpr' + i\" [formControlName]=\"i\" [ngClass]=\"{'is-valid': control.valid, 'is-invalid': !(control.valid || control.pristine)}\">\n        </fieldset>\n      </div>\n    </div>\n  </div>\n</div>\n\n\n"

/***/ }),

/***/ "./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.ts":
/*!***************************************************************************************!*\
  !*** ./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.ts ***!
  \***************************************************************************************/
/*! exports provided: ScopeExpressionWizardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ScopeExpressionWizardComponent", function() { return ScopeExpressionWizardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_specification__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../models/specification */ "./src/app/models/specification.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _services_requirement_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../services/requirement.service */ "./src/app/services/requirement.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _services_io_table_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../services/io-table.service */ "./src/app/services/io-table.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var ScopeExpressionWizardComponent = /** @class */ (function () {
    function ScopeExpressionWizardComponent(fb, reqService, ioTableService) {
        this.fb = fb;
        this.reqService = reqService;
        this.ioTableService = ioTableService;
        this._scope = null;
        this._delay = null;
        this.scopeForm = this.fb.group({
            scopeFormArray: this.fb.array([]),
        });
        this.delayForm = this.fb.group({
            delayFormArray: this.fb.array([]),
        });
        this.filteredOptions = [];
        this.scopeChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.scopeValidChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
    }
    ScopeExpressionWizardComponent.prototype.ngOnInit = function () {
    };
    ScopeExpressionWizardComponent.prototype.filter = function (value) {
        return this.ioTableService.getItems().filter(function (item) { return item.includes(value); });
    };
    ScopeExpressionWizardComponent.prototype.onChange = function () {
        var _this = this;
        while (this.scopeFormArray.length > 0) {
            this.scopeFormArray.removeAt(this.scopeFormArray.length - 1);
        }
        this.filteredOptions.splice(0, this.filteredOptions.length);
        this._scope.getAllEndPoints().forEach(function (endPoint, index) {
            var control = _this.fb.control(endPoint.name, [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].pattern(/^\S+$/)]);
            _this.filteredOptions[index] = control.valueChanges.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["tap"])(function (value) { endPoint.name = value; _this.update(); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["startWith"])(''), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["map"])(function (value) { return _this.filter(value); }));
            _this.scopeFormArray.push(control);
        });
    };
    Object.defineProperty(ScopeExpressionWizardComponent.prototype, "scopeFormArray", {
        get: function () {
            return this.scopeForm.get('scopeFormArray');
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ScopeExpressionWizardComponent.prototype, "delayFormArray", {
        get: function () {
            return this.delayForm.get('delayFormArray');
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ScopeExpressionWizardComponent.prototype, "scope", {
        get: function () {
            return this._scope;
        },
        set: function (scope) {
            this._scope = scope;
            switch (this._scope.endPointsNum) {
                case 1: {
                    this._scope.leftEndpoint = new _models_specification__WEBPACK_IMPORTED_MODULE_1__["Endpoint"]('', false, null, null);
                    break;
                }
                case 2: {
                    this._scope.leftEndpoint = new _models_specification__WEBPACK_IMPORTED_MODULE_1__["Endpoint"]('', false, null, null);
                    this._scope.rightEndpoint = new _models_specification__WEBPACK_IMPORTED_MODULE_1__["Endpoint"]('', false, null, null);
                    break;
                }
                default: {
                    break;
                }
            }
            this.onChange();
            this.update();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ScopeExpressionWizardComponent.prototype, "delay", {
        get: function () {
            return this._delay;
        },
        set: function (delay) {
            var _this = this;
            this._delay = delay;
            if (this._delay !== null) {
                this._delay.vars = new Array(this._delay.varNum).fill('');
                while (this.delayFormArray.length > 0) {
                    this.delayFormArray.removeAt(this.delayFormArray.length - 1);
                }
                var _loop_1 = function (index) {
                    var control = this_1.fb.control('', [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].pattern('^[0-9]|[1-9][0-9]*$')]);
                    control.valueChanges.subscribe(function (value) {
                        _this._delay.vars[index] = value;
                        _this.update();
                    });
                    this_1.delayFormArray.push(control);
                };
                var this_1 = this;
                for (var index = 0; index < this._delay.varNum; index++) {
                    _loop_1(index);
                }
                this.update();
            }
        },
        enumerable: true,
        configurable: true
    });
    ScopeExpressionWizardComponent.prototype.add = function (endPoint, catg, index) {
        var newLeftChild = new _models_specification__WEBPACK_IMPORTED_MODULE_1__["Endpoint"](endPoint.name, false, null, null);
        var newRightChild = new _models_specification__WEBPACK_IMPORTED_MODULE_1__["Endpoint"]('', false, null, null);
        switch (catg) {
            case 'and': {
                endPoint.andGroup = [newLeftChild, newRightChild];
                break;
            }
            case 'or': {
                endPoint.orGroup = [newLeftChild, newRightChild];
                break;
            }
            default: {
                break;
            }
        }
        endPoint.name = '';
        this.onChange();
        this.update();
    };
    ScopeExpressionWizardComponent.prototype.not = function (endPoint) {
        endPoint.isNot = !endPoint.isNot;
        this.update();
    };
    ScopeExpressionWizardComponent.prototype.updateDelay = function () {
        if (this._delay !== null) {
            var delay_1 = this._delay;
            this._delay.text = this._delay.template.replace(/{t(\d+)}/g, function (match, number) {
                return delay_1.vars[parseInt(number, 10) - 1] === '' ? match : delay_1.vars[parseInt(number, 10) - 1];
            });
        }
    };
    ScopeExpressionWizardComponent.prototype.update = function () {
        this.updateDelay();
        var leftEndPoint = this._scope.leftEndpoint;
        var rightEndPoint = this._scope.rightEndpoint;
        var index = new _models_specification__WEBPACK_IMPORTED_MODULE_1__["Index"](0);
        this._scope.text = this.scope.template.replace(/{(\d+)}/g, function (match, number) {
            switch (number) {
                case '1': {
                    return leftEndPoint.toText(index);
                }
                case '2': {
                    return rightEndPoint.toText(index);
                }
                default: {
                    console.log('match: ' + match + ', ' + typeof match);
                    console.log('number: ' + number + ', ' + typeof number);
                    break;
                }
            }
        });
        this.scopeValidChanged.emit(this.scopeFormArray.controls.every(function (control) { return control.valid; }) &&
            this.delayFormArray.controls.every(function (control) { return control.valid; }));
        this.scopeChanged.emit(this._scope);
    };
    ScopeExpressionWizardComponent.prototype.customTrackBy = function (index, obj) {
        return obj;
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], ScopeExpressionWizardComponent.prototype, "projectId", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], ScopeExpressionWizardComponent.prototype, "scopeChanged", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], ScopeExpressionWizardComponent.prototype, "scopeValidChanged", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", _models_specification__WEBPACK_IMPORTED_MODULE_1__["Scope"]),
        __metadata("design:paramtypes", [_models_specification__WEBPACK_IMPORTED_MODULE_1__["Scope"]])
    ], ScopeExpressionWizardComponent.prototype, "scope", null);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", _models_specification__WEBPACK_IMPORTED_MODULE_1__["Delay"]),
        __metadata("design:paramtypes", [_models_specification__WEBPACK_IMPORTED_MODULE_1__["Delay"]])
    ], ScopeExpressionWizardComponent.prototype, "delay", null);
    ScopeExpressionWizardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-scope-expression-wizard',
            template: __webpack_require__(/*! ./scope-expression-wizard.component.html */ "./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.html"),
            styles: [__webpack_require__(/*! ./scope-expression-wizard.component.css */ "./src/app/pattern-wizard/expression-wizard/scope-expression-wizard.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _services_requirement_service__WEBPACK_IMPORTED_MODULE_3__["RequirementService"],
            _services_io_table_service__WEBPACK_IMPORTED_MODULE_5__["IoTableService"]])
    ], ScopeExpressionWizardComponent);
    return ScopeExpressionWizardComponent;
}());



/***/ }),

/***/ "./src/app/pattern-wizard/pattern-wizard.component.css":
/*!*************************************************************!*\
  !*** ./src/app/pattern-wizard/pattern-wizard.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n\r\n.req-field {\r\n  display: block;\r\n  overflow: hidden;\r\n}\r\n\r\n.req-field > input {\r\n  width: 100%;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcGF0dGVybi13aXphcmQvcGF0dGVybi13aXphcmQuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOztBQUVBO0VBQ0UsY0FBYztFQUNkLGdCQUFnQjtBQUNsQjs7QUFFQTtFQUNFLFdBQVc7QUFDYiIsImZpbGUiOiJzcmMvYXBwL3BhdHRlcm4td2l6YXJkL3BhdHRlcm4td2l6YXJkLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuXHJcbi5yZXEtZmllbGQge1xyXG4gIGRpc3BsYXk6IGJsb2NrO1xyXG4gIG92ZXJmbG93OiBoaWRkZW47XHJcbn1cclxuXHJcbi5yZXEtZmllbGQgPiBpbnB1dCB7XHJcbiAgd2lkdGg6IDEwMCU7XHJcbn1cclxuIl19 */"

/***/ }),

/***/ "./src/app/pattern-wizard/pattern-wizard.component.html":
/*!**************************************************************!*\
  !*** ./src/app/pattern-wizard/pattern-wizard.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1>New Requirement</h1>\r\n\r\n<ol class=\"breadcrumb mb-4\">\r\n  <li class=\"breadcrumb-item\"><a href=\"#\">Projects</a></li>\r\n  <li class=\"breadcrumb-item\"><a routerLink=\"/projects/{{project.id}}\">{{ project.name }}</a></li>\r\n  <li class=\"breadcrumb-item active\">New Requirement</li>\r\n</ol>\r\n\r\n<div class=\"\">\r\n<!--  <div class=\"form-group row pb-2\">-->\r\n<!--    <label class=\"col-form-label col-sm-2 text-right\" for=\"reqText\">Req ID</label>-->\r\n<!--    <div class=\"col-sm-10\">-->\r\n<!--      <input class=\"form-control w-auto\" type=\"text\" id=\"reqId\" (change)=\"updateReqId($event)\">-->\r\n<!--    </div>-->\r\n<!--  </div>-->\r\n  <div class=\"form-group row\">\r\n    <label class=\"col-form-label col-sm-2 text-right\" for=\"reqText\">Requirement</label>\r\n    <div class=\"col-sm-10 pr-5\">\r\n      <input class=\"form-control w-100\" type=\"text\" id=\"reqText\" readonly=\"\" data-cip-id=\"readOnlyInput\"\r\n             value=\"{{req}}\">\r\n    </div>\r\n\r\n  </div>\r\n</div>\r\n\r\n<div class=\"row equal\">\r\n  <div class=\"col-md-6 pl-3 pr-1\">\r\n    <div class=\"card bg-secondary h-100\">\r\n      <div class=\"card-body\">\r\n        <h4 class=\"card-title\">Scope\r\n          <small><i class=\"fa fa-info-circle\" data-toggle=\"tooltip\" data-placement=\"right\"\r\n                    title=\"Scope是对Property的成立范围的要求。\"></i></small>\r\n        </h4>\r\n        <div class=\"row\">\r\n          <div class=\"col-md-4 pr-0\">\r\n            <div class=\"dropdown\">\r\n              <button class=\"btn btn-secondary dropdown-toggle w-100\" type=\"button\"\r\n                      data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n                {{selectedScope.name}}\r\n              </button>\r\n\r\n              <ul dropdownMenu class=\"dropdown-menu\" role=\"menu\">\r\n                <li *ngFor=\"let scope of scopes\" (click)=\"selectScope(scope)\"\r\n                    class=\"dropdown-item\">{{scope.name}}\r\n                </li>\r\n              </ul>\r\n            </div>\r\n            <div class=\"mt-2\">\r\n              <small class=\"text-justify \"><p class=\"text-muted\">{{selectedScope.description}}</p></small>\r\n            </div>\r\n\r\n            <div class=\"dropdown\">\r\n              <button class=\"btn btn-secondary dropdown-toggle w-100\" type=\"button\"\r\n                      data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n                {{ selectedDelay === null ? 'Delay' : selectedDelay.name }}\r\n              </button>\r\n\r\n              <ul dropdownMenu class=\"dropdown-menu\" role=\"menu\">\r\n                <li *ngFor=\"let delay of selectedScope.candidateDelay\" (click)=\"selectDelay(delay)\"\r\n                    class=\"dropdown-item\">{{delay.name}}\r\n                </li>\r\n              </ul>\r\n            </div>\r\n            <div class=\"mt-2\">\r\n              <small class=\"text-justify \"><p class=\"text-muted\">{{selectedDelay === null ? 'Delay可以分别对Scope的左右端点成立时间进行延时。' : selectedDelay.description}}</p></small>\r\n            </div>\r\n\r\n\r\n          </div>\r\n          <div class=\"col-md-8\">\r\n            <app-scope-expression-wizard [scope]=\"selectedScope\" [delay]=\"selectedDelay\" [projectId]=\"project.id\" (scopeChanged)=\"updateRequirement()\" (scopeValidChanged)=\"updateScopeValid($event)\"></app-scope-expression-wizard>\r\n          </div>\r\n        </div>\r\n\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n  <div class=\"col-md-6 pl-1 pr-3\">\r\n    <div class=\"card bg-secondary h-100\">\r\n      <div class=\"card-body\">\r\n        <h4 class=\"card-title\">Property\r\n          <small><i class=\"fa fa-info-circle\" data-toggle=\"tooltip\" data-placement=\"right\"\r\n                            title=\"Property是对控制对象的要求。\"></i></small>\r\n        </h4>\r\n        <div class=\"row\">\r\n          <div class=\"col-md-4 pr-0\">\r\n            <div class=\"dropdown\">\r\n              <button class=\"btn btn-secondary dropdown-toggle w-100\" type=\"button\"\r\n                      data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n                {{ selectedProperty.name }}\r\n              </button>\r\n\r\n              <ul dropdownMenu class=\"dropdown-menu\" role=\"menu\">\r\n                <li *ngFor=\"let property of properties\" (click)=\"selectProperty(property)\"\r\n                    class=\"dropdown-item\">{{property.name}}\r\n                </li>\r\n              </ul>\r\n            </div>\r\n            <div class=\"mt-2\">\r\n              <small class=\"text-justify\"><p class=\"text-muted\">{{selectedProperty.description}}</p></small>\r\n            </div>\r\n\r\n            <div class=\"dropdown\">\r\n              <button class=\"btn btn-secondary dropdown-toggle w-100\" type=\"button\"\r\n                      data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n                Add Property\r\n              </button>\r\n\r\n              <ul dropdownMenu class=\"dropdown-menu\" role=\"menu\">\r\n                <li *ngFor=\"let property of properties\" (click)=\"selectAdditionalProperty(property)\"\r\n                    class=\"dropdown-item\">{{property.name}}\r\n                </li>\r\n              </ul>\r\n            </div>\r\n            <div class=\"mt-2\">\r\n              <small class=\"text-justify\"><p class=\"text-muted\">{{ '在同一Scope下添加额外的Property。' }}</p></small>\r\n            </div>\r\n\r\n          </div>\r\n          <div class=\"col-md-8\">\r\n            <app-property-expression-wizard [property]=\"selectedProperty\" [additionalProperties]=\"additionalProperties\" [projectId]=\"project.id\" (propertyChanged)=\"updateRequirement()\" (propertyValidChanged)=\"updatePropertyValid($event)\"></app-property-expression-wizard>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n</div>\r\n\r\n<div class=\"pt-3 pr-1\">\r\n  <button class=\"btn btn-primary float-right\" (click)=\"createRequirement()\" [disabled]=\"!(propertyValid && scopeValid)\">Create</button>\r\n  <button id=\"wrongRequirementButton\" hidden data-toggle=\"modal\" data-target=\"#wrongRequirementModal\"></button>\r\n\r\n  <!-- The Modal-->\r\n  <div class=\"modal fade\" id=\"wrongRequirementModal\">\r\n    <div class=\"modal-dialog\">\r\n      <div class=\"modal-content\">\r\n        <div class=\"modal-header\">\r\n          <h4 class=\"modal-title\">Wrong Requirement</h4>\r\n          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n        </div>\r\n\r\n        <div class=\"modal-body\">\r\n          The requirement is not valid!\r\n        </div>\r\n\r\n        <div class=\"modal-footer\">\r\n          <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n\r\n\r\n"

/***/ }),

/***/ "./src/app/pattern-wizard/pattern-wizard.component.ts":
/*!************************************************************!*\
  !*** ./src/app/pattern-wizard/pattern-wizard.component.ts ***!
  \************************************************************/
/*! exports provided: PatternWizardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PatternWizardComponent", function() { return PatternWizardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _models_project__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../models/project */ "./src/app/models/project.ts");
/* harmony import */ var _services_requirement_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/requirement.service */ "./src/app/services/requirement.service.ts");
/* harmony import */ var _models_requirement__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../models/requirement */ "./src/app/models/requirement.ts");
/* harmony import */ var _models_specification__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../models/specification */ "./src/app/models/specification.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var PatternWizardComponent = /** @class */ (function () {
    function PatternWizardComponent(route, router, projectService, requirementService) {
        this.route = route;
        this.router = router;
        this.projectService = projectService;
        this.requirementService = requirementService;
        this.delayWithEnd1 = new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Delay"]('DelayWithEnd1', 'between {t1} timeUnits and {t2} timeUnits', 2, 'DelayWithEnd1使Scope的左端点成立时间相对原左端点延迟t1个时间单位，并且若原Scope的时间长度大于t2个时间单位，则Scope的右端点成立时间相对原左端点延迟t2个时间单位。');
        this.delayWithEnd2 = new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Delay"]('DelayWithEnd2', 'within {t1} timeUnits', 1, 'DelayWithEnd2使Scope的左端点成立时间相对原左端点延迟0个时间单位，并且若原Scope的时间长度大于t1个时间单位，则Scope的右端点成立时间相对原左端点延迟t1个时间单位。');
        this.delayWithoutEnd = new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Delay"]('DelayWithoutEnd', 'after {t1} timeUnits', 1, 'DelayWithoutEnd使Scope的左端点成立时间相对原左端点延迟t1个时间单位。');
        this.delayOnBothSides = new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Delay"]('DelayOnBothSides', 'after {t1} timeUnits and the property still holds for {t2} timeUnits after the end of the scope', 2, 'DelayOnBothSides使Scope的左端点成立时间相对原左端点延迟t1个时间单位，同时使右端点成立时间相对原右端点延迟t2个时间单位。');
        this.delayOnRightSide = new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Delay"]('DelayOnRightSide', 'and the property still holds for {t1} timeUnits after the end of the scope', 1, 'DelayOnRightSide使Scope右端点成立时间相对原右端点延迟t1个时间单位。');
        this.scopes = [
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Scope"]('Globally', 'Globally', 'Globally对Property的成立Scope无要求。', 0, [this.delayWithoutEnd, this.delayWithEnd1, this.delayWithEnd2]),
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Scope"]('After Q', 'After {1}', 'After Q要求Property在Q成立后必须成立。', 1, [this.delayWithoutEnd, this.delayWithEnd1, this.delayWithEnd2]),
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Scope"]('After Q until R', 'After {1} until {2}', 'After Q until R要求Property在Q成立之后，在R成立之前的Scope内必须成立。', 2, [this.delayWithoutEnd, this.delayWithEnd1, this.delayWithEnd2, this.delayOnRightSide, this.delayOnBothSides]),
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Scope"]('When Q', 'When {1}', 'When Q要求Property在Q成立时也必须成立。', 1, [this.delayWithoutEnd, this.delayWithEnd1, this.delayWithEnd2, this.delayOnRightSide, this.delayOnBothSides]),
        ];
        this.properties = [
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Property"]('Universality', 'it is always the case that {1} holds', 1, 'Universality要求控制对象在Scope内持续成立。'),
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Property"]('Absence', 'it is never the case that {1} holds', 1, 'Absence要求控制对象在Scope内始终不成立。'),
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Property"]('Existence', '{1} exists immediately', 1, 'Existence要求控制对象在Scope的第一个时间点成立一次，在Scope内的其余时间点皆不成立。'),
            new _models_specification__WEBPACK_IMPORTED_MODULE_6__["Property"]('Interlock', 'it is never the case that ({1} and {2}) hold', 2, 'Interlock要求两个控制对象在Scope内不能同时成立。')
        ];
        this.selectedScope = null;
        this.selectedProperty = null;
        this.selectedDelay = null;
        this.req = '';
        this.project = new _models_project__WEBPACK_IMPORTED_MODULE_3__["Project"](null, null, null);
        this.scopeValid = false;
        this.propertyValid = false;
    }
    PatternWizardComponent.prototype.ngOnInit = function () {
        this.selectedScope = this.scopes[0];
        this.selectedProperty = this.properties[0];
        this.additionalProperties = new Array();
        this.getProject();
    };
    PatternWizardComponent.prototype.updateScopeValid = function (scopeValid) {
        this.scopeValid = scopeValid;
    };
    PatternWizardComponent.prototype.updatePropertyValid = function (propertyValid) {
        this.propertyValid = propertyValid;
    };
    PatternWizardComponent.prototype.getProject = function () {
        var _this = this;
        var projectId = +this.route.snapshot.paramMap.get('projectId');
        this.projectService.getProject(projectId).subscribe(function (project) { return _this.project = project; });
    };
    PatternWizardComponent.prototype.selectScope = function (selected) {
        this.selectedScope = selected;
        this.selectedDelay = null;
        this.updateRequirement();
    };
    PatternWizardComponent.prototype.selectProperty = function (selected) {
        this.selectedProperty = selected;
        this.additionalProperties = [];
        this.updateRequirement();
    };
    PatternWizardComponent.prototype.selectAdditionalProperty = function (selected) {
        this.additionalProperties = this.additionalProperties.concat([selected.copy()]);
        // console.log(this.additionalProperties);
    };
    PatternWizardComponent.prototype.selectDelay = function (delay) {
        this.selectedDelay = delay;
    };
    PatternWizardComponent.prototype.updateRequirement = function () {
        var propertiesTexts = [this.selectedProperty.text].concat(this.additionalProperties.map(function (property) { return property.text; }));
        this.req = this.selectedScope.text +
            ', ' +
            propertiesTexts.join(' and ') +
            (this.selectedDelay === null ? '.' : ' ' + this.selectedDelay.text + '.');
    };
    PatternWizardComponent.prototype.createRequirement = function () {
        var _this = this;
        if ((this.selectedProperty.name === 'Existence' && this.selectedDelay !== null && this.selectedDelay !== this.delayWithoutEnd) ||
            (this.selectedProperty.name === 'Interlock' && this.selectedScope.name !== 'Globally')) {
            document.getElementById('wrongRequirementButton').click();
            return;
        }
        var savedReqText = [this.selectedProperty.text]
            .concat(this.additionalProperties.map(function (property) { return property.text; }))
            .map(function (property) {
            return _this.selectedScope.text + ', ' + property + (_this.selectedDelay === null ? '.' : ' ' + _this.selectedDelay.text + '.');
        });
        var observableBatch = [];
        var projId = this.project.id;
        savedReqText.forEach(function (req) {
            var requirement = new _models_requirement__WEBPACK_IMPORTED_MODULE_5__["Requirement"]();
            requirement.text = req;
            requirement.project = projId;
            requirement.disabled = false;
            requirement.state = _models_requirement__WEBPACK_IMPORTED_MODULE_5__["ReqState"].COMPLIANT;
            observableBatch.push(_this.requirementService.createRequirement(requirement));
        });
        Object(rxjs__WEBPACK_IMPORTED_MODULE_7__["forkJoin"])(observableBatch).subscribe({
            complete: function () { return _this.router.navigateByUrl('/projects/' + projId); }
        });
    };
    PatternWizardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-pattern-wizard',
            template: __webpack_require__(/*! ./pattern-wizard.component.html */ "./src/app/pattern-wizard/pattern-wizard.component.html"),
            styles: [__webpack_require__(/*! ./pattern-wizard.component.css */ "./src/app/pattern-wizard/pattern-wizard.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            _services_project_service__WEBPACK_IMPORTED_MODULE_1__["ProjectService"],
            _services_requirement_service__WEBPACK_IMPORTED_MODULE_4__["RequirementService"]])
    ], PatternWizardComponent);
    return PatternWizardComponent;
}());



/***/ }),

/***/ "./src/app/project-details/io-table-tab/io-table-tab.component.css":
/*!*************************************************************************!*\
  !*** ./src/app/project-details/io-table-tab/io-table-tab.component.css ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".tab-header {\n  margin: 1em 0;\n  display: -webkit-box;\n  display: flex;\n  height: 2.5em;\n  width: 100%;\n}\n\n.btn {\n  margin-left: 0.5em;\n}\n\n.hidden {\n  display: none !important;\n  visibility: hidden !important;\n}\n\n.search-field {\n  width:100%;\n  margin: 0;\n}\n\n.tab-progress {\n  margin-top: 1em;\n}\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvamVjdC1kZXRhaWxzL2lvLXRhYmxlLXRhYi9pby10YWJsZS10YWIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGFBQWE7RUFDYixvQkFBYTtFQUFiLGFBQWE7RUFDYixhQUFhO0VBQ2IsV0FBVztBQUNiOztBQUVBO0VBQ0Usa0JBQWtCO0FBQ3BCOztBQUVBO0VBQ0Usd0JBQXdCO0VBQ3hCLDZCQUE2QjtBQUMvQjs7QUFHQTtFQUNFLFVBQVU7RUFDVixTQUFTO0FBQ1g7O0FBRUE7RUFDRSxlQUFlO0FBQ2pCIiwiZmlsZSI6InNyYy9hcHAvcHJvamVjdC1kZXRhaWxzL2lvLXRhYmxlLXRhYi9pby10YWJsZS10YWIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi50YWItaGVhZGVyIHtcbiAgbWFyZ2luOiAxZW0gMDtcbiAgZGlzcGxheTogZmxleDtcbiAgaGVpZ2h0OiAyLjVlbTtcbiAgd2lkdGg6IDEwMCU7XG59XG5cbi5idG4ge1xuICBtYXJnaW4tbGVmdDogMC41ZW07XG59XG5cbi5oaWRkZW4ge1xuICBkaXNwbGF5OiBub25lICFpbXBvcnRhbnQ7XG4gIHZpc2liaWxpdHk6IGhpZGRlbiAhaW1wb3J0YW50O1xufVxuXG5cbi5zZWFyY2gtZmllbGQge1xuICB3aWR0aDoxMDAlO1xuICBtYXJnaW46IDA7XG59XG5cbi50YWItcHJvZ3Jlc3Mge1xuICBtYXJnaW4tdG9wOiAxZW07XG59XG5cbiJdfQ== */"

/***/ }),

/***/ "./src/app/project-details/io-table-tab/io-table-tab.component.html":
/*!**************************************************************************!*\
  !*** ./src/app/project-details/io-table-tab/io-table-tab.component.html ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row tab-header\">\n  <div class=\"col-10 pl-0\">\n\n    <button type=\"button\" class=\"btn btn-outline-primary\" data-toggle=\"modal\" data-target=\"#addIOModal\">\n      <i class=\"fa fa-plus\" aria-hidden=\"true\"></i>\n      &nbsp;Add IO\n    </button>\n\n    <button type=\"button\" class=\"btn btn-outline-primary\" (click)=\"deleteSelected()\" [disabled]=\"selected.length === 0\">\n      <i class=\"fa fa-trash\" aria-hidden=\"true\"></i>\n      &nbsp;Delete IO\n    </button>\n\n  </div>\n  <div class=\"col-2 pr-0\">\n    <input\n      type='text'\n      class=\"form-control search-field pull-right\"\n      placeholder='Search...'\n      (keyup)='updateFilter($event)'\n      [(ngModel)]=\"searchValue\"\n    />\n  </div>\n</div>\n\n<ngx-datatable #table\n               class=\"material\"\n               [columnMode]=\"'standard'\"\n               [headerHeight]=\"50\"\n               [footerHeight]=\"50\"\n               [rowHeight]=\"'auto'\"\n               [limit]=\"10\"\n               [selected]=\"selected\"\n               [selectionType]=\"'checkbox'\"\n               [rows]='rows'\n               [rowClass]=\"getRowClass\"\n               [reorderable]=\"true\">\n  <ngx-datatable-column\n    [width]=\"30\"\n    [sortable]=\"false\"\n    [canAutoResize]=\"false\"\n    [draggable]=\"false\"\n    [resizeable]=\"false\"\n    [headerCheckboxable]=\"false\"\n    [checkboxable]=\"true\">\n  </ngx-datatable-column>\n  <ngx-datatable-column name=\"IO Name\" prop=\"IOName\" [width]=\"700\"></ngx-datatable-column>\n  <ngx-datatable-column name=\"IO Number\" prop=\"IONumber\" [width]=\"350\"></ngx-datatable-column>\n</ngx-datatable>\n\n\n\n<div class=\"modal fade\" tabindex=\"-1\" id=\"addIOModal\" role=\"dialog\">\n  <div class=\"modal-dialog\" role=\"document\">\n    <div class=\"modal-content\">\n      <div class=\"modal-header\">\n        <h5 class=\"modal-title\">New IO</h5>\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n          <span aria-hidden=\"true\">&times;</span>\n        </button>\n      </div>\n      <form [formGroup]=\"IOForm\">\n        <div class=\"modal-body\">\n          <div class=\"form-group\">\n            <label class=\"form-control-label\" for=\"IOName\">IO Name</label>\n            <input class=\"form-control\" id=\"IOName\" type=\"text\" formControlName=\"IOName\">\n          </div>\n          <div class=\"form-group\">\n            <label class=\"form-control-label\" for=\"IONumber\">IO Number</label>\n            <input class=\"form-control\" id=\"IONumber\" type=\"text\" formControlName=\"IONumber\">\n          </div>\n        </div>\n        <div class=\"modal-footer\">\n          <button type=\"submit\" class=\"btn btn-primary\" (click)=\"addIO()\">Save\n          </button>\n          <button type=\"reset\" class=\"btn btn-secondary\" data-dismiss=\"modal\" (click)=\"reset()\" #closeBtn>Close</button>\n        </div>\n      </form>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/project-details/io-table-tab/io-table-tab.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/project-details/io-table-tab/io-table-tab.component.ts ***!
  \************************************************************************/
/*! exports provided: IoTableTabComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IoTableTabComponent", function() { return IoTableTabComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_io__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../models/io */ "./src/app/models/io.ts");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/release/index.js");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _services_io_table_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../services/io-table.service */ "./src/app/services/io-table.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../alert/alert.service */ "./src/app/alert/alert.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var IoTableTabComponent = /** @class */ (function () {
    function IoTableTabComponent(ioTableService, fb, alertService) {
        this.ioTableService = ioTableService;
        this.fb = fb;
        this.alertService = alertService;
        this.rows = [];
        this.searchValue = '';
        this.selected = [];
        this.IOForm = fb.group({
            'IOName': new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"](''),
            'IONumber': new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"]('')
        });
    }
    IoTableTabComponent.prototype.ngOnInit = function () {
        this.getIOTable();
    };
    IoTableTabComponent.prototype.getIOTable = function () {
        var _this = this;
        this.ioTableService.getIoTable(this.projectId).subscribe(function (ioTable) {
            _this.ioTable = ioTable.map(function (ioMap) { return new _models_io__WEBPACK_IMPORTED_MODULE_1__["IOMap"](ioMap); });
            _this.rows = ioTable;
        });
    };
    IoTableTabComponent.prototype.getRowClass = function (row) {
        return {
            'row-green': true
        };
    };
    IoTableTabComponent.prototype.addIO = function () {
        var _this = this;
        var ioName = this.IOForm.value.IOName;
        var ioNumber = this.IOForm.value.IONumber;
        this.ioTableService.addIOMap(new _models_io__WEBPACK_IMPORTED_MODULE_1__["IOMap"]({
            id: null,
            projectId: this.projectId,
            IOName: ioName,
            IONumber: ioNumber
        }))
            .subscribe(function (ioMap) {
            _this.ioTable.push(ioMap);
            _this.updateFilter(null);
            _this.closeBtn.nativeElement.click();
        });
    };
    IoTableTabComponent.prototype.deleteSelected = function () {
        var _this = this;
        var ioMaps = this.selected;
        ioMaps.forEach(function (ioMap) {
            _this.ioTableService.deleteIOMap(ioMap.id).subscribe(function (response) {
                var index = _this.ioTable.findIndex(function (val) { return val.id === response.body.id; });
                if (index !== -1) {
                    _this.ioTable.splice(index, 1);
                }
                _this.updateFilter(null);
            }, function (error) { return _this.alertService.error(error); });
        });
    };
    IoTableTabComponent.prototype.updateFilter = function (event) {
        var val = this.searchValue.toLowerCase();
        var temp = this.ioTable.filter(function (ioMap) {
            return ioMap.IONumber.toLowerCase().indexOf(val) !== -1 || ioMap.IOName.toLowerCase().indexOf(val) !== -1 || !val;
        });
        this.rows = temp;
        if (event != null) {
            this.table.offset = 0;
        }
        this.selected = [];
    };
    IoTableTabComponent.prototype.reset = function () {
        this.IOForm.reset();
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Number)
    ], IoTableTabComponent.prototype, "projectId", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])('closeBtn'),
        __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"])
    ], IoTableTabComponent.prototype, "closeBtn", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_2__["DatatableComponent"]),
        __metadata("design:type", _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_2__["DatatableComponent"])
    ], IoTableTabComponent.prototype, "table", void 0);
    IoTableTabComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-io-table-tab',
            template: __webpack_require__(/*! ./io-table-tab.component.html */ "./src/app/project-details/io-table-tab/io-table-tab.component.html"),
            styles: [__webpack_require__(/*! ./io-table-tab.component.css */ "./src/app/project-details/io-table-tab/io-table-tab.component.css")]
        }),
        __metadata("design:paramtypes", [_services_io_table_service__WEBPACK_IMPORTED_MODULE_3__["IoTableService"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormBuilder"],
            _alert_alert_service__WEBPACK_IMPORTED_MODULE_5__["AlertService"]])
    ], IoTableTabComponent);
    return IoTableTabComponent;
}());



/***/ }),

/***/ "./src/app/project-details/project-details.component.css":
/*!***************************************************************!*\
  !*** ./src/app/project-details/project-details.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".top-container {\r\n  margin-bottom: 2em;\r\n}\r\n\r\n.hidden {\r\n  display: none !important;\r\n  visibility: hidden !important;\r\n}\r\n\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvamVjdC1kZXRhaWxzL3Byb2plY3QtZGV0YWlscy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usa0JBQWtCO0FBQ3BCOztBQUVBO0VBQ0Usd0JBQXdCO0VBQ3hCLDZCQUE2QjtBQUMvQiIsImZpbGUiOiJzcmMvYXBwL3Byb2plY3QtZGV0YWlscy9wcm9qZWN0LWRldGFpbHMuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi50b3AtY29udGFpbmVyIHtcclxuICBtYXJnaW4tYm90dG9tOiAyZW07XHJcbn1cclxuXHJcbi5oaWRkZW4ge1xyXG4gIGRpc3BsYXk6IG5vbmUgIWltcG9ydGFudDtcclxuICB2aXNpYmlsaXR5OiBoaWRkZW4gIWltcG9ydGFudDtcclxufVxyXG5cclxuXHJcblxyXG4iXX0= */"

/***/ }),

/***/ "./src/app/project-details/project-details.component.html":
/*!****************************************************************!*\
  !*** ./src/app/project-details/project-details.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row top-container\">\r\n  <div class=\"col-md-8\">\r\n    <h1 *ngIf=\"project != null\">{{ project.name }}</h1>\r\n  </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"container\">\r\n\r\n  <ul class=\"nav nav-tabs\">\r\n    <li class=\"nav-item\">\r\n      <a class=\"nav-link active show\" data-toggle=\"tab\" href=\"#requirements\">Requirements</a>\r\n    </li>\r\n    <li class=\"nav-item\">\r\n      <a class=\"nav-link\" data-toggle=\"tab\" href=\"#tasks\">Tasks</a>\r\n    </li>\r\n    <li class=\"nav-item\">\r\n      <a class=\"nav-link\" data-toggle=\"tab\" href=\"#io-table\">I/O table</a>\r\n    </li>\r\n  </ul>\r\n\r\n  <div class=\"tab-content\">\r\n    <div class=\"tab-pane fade in active show\" id=\"requirements\">\r\n      <app-requirements-tab [projectId]=\"projectId\"></app-requirements-tab>\r\n    </div>\r\n\r\n    <div class=\"tab-pane fade show\" id=\"tasks\">\r\n      <app-tasks-tab [projectId]=\"projectId\"></app-tasks-tab>\r\n    </div>\r\n\r\n    <div class=\"tab-pane fade show\" id=\"io-table\">\r\n      <app-io-table-tab [projectId]=\"projectId\"></app-io-table-tab>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n"

/***/ }),

/***/ "./src/app/project-details/project-details.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/project-details/project-details.component.ts ***!
  \**************************************************************/
/*! exports provided: ProjectDetailsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectDetailsComponent", function() { return ProjectDetailsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ProjectDetailsComponent = /** @class */ (function () {
    function ProjectDetailsComponent(route, projectService) {
        this.route = route;
        this.projectService = projectService;
    }
    ProjectDetailsComponent.prototype.ngOnInit = function () {
        this.projectId = +this.route.snapshot.paramMap.get('projectId');
        this.getProject();
    };
    ProjectDetailsComponent.prototype.getProject = function () {
        var _this = this;
        this.projectService.getProject(this.projectId).subscribe(function (project) { return _this.project = project; });
    };
    ProjectDetailsComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-details',
            template: __webpack_require__(/*! ./project-details.component.html */ "./src/app/project-details/project-details.component.html"),
            styles: [__webpack_require__(/*! ./project-details.component.css */ "./src/app/project-details/project-details.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"],
            _services_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"]])
    ], ProjectDetailsComponent);
    return ProjectDetailsComponent;
}());



/***/ }),

/***/ "./src/app/project-details/requirements-tab/requirements-tab.component.css":
/*!*********************************************************************************!*\
  !*** ./src/app/project-details/requirements-tab/requirements-tab.component.css ***!
  \*********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".tab-header {\r\n  margin: 1em 0;\r\n  display: -webkit-box;\r\n  display: flex;\r\n  height: 2.5em;\r\n  width: 100%;\r\n}\r\n\r\n.btn {\r\n  margin-left: 0.5em;\r\n}\r\n\r\n.hidden {\r\n  display: none !important;\r\n  visibility: hidden !important;\r\n}\r\n\r\n.search-field {\r\n  width:100%;\r\n  margin: 0;\r\n}\r\n\r\n.tab-progress {\r\n  margin-top: 1em;\r\n}\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvamVjdC1kZXRhaWxzL3JlcXVpcmVtZW50cy10YWIvcmVxdWlyZW1lbnRzLXRhYi5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsYUFBYTtFQUNiLG9CQUFhO0VBQWIsYUFBYTtFQUNiLGFBQWE7RUFDYixXQUFXO0FBQ2I7O0FBRUE7RUFDRSxrQkFBa0I7QUFDcEI7O0FBRUE7RUFDRSx3QkFBd0I7RUFDeEIsNkJBQTZCO0FBQy9COztBQUdBO0VBQ0UsVUFBVTtFQUNWLFNBQVM7QUFDWDs7QUFFQTtFQUNFLGVBQWU7QUFDakIiLCJmaWxlIjoic3JjL2FwcC9wcm9qZWN0LWRldGFpbHMvcmVxdWlyZW1lbnRzLXRhYi9yZXF1aXJlbWVudHMtdGFiLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIudGFiLWhlYWRlciB7XHJcbiAgbWFyZ2luOiAxZW0gMDtcclxuICBkaXNwbGF5OiBmbGV4O1xyXG4gIGhlaWdodDogMi41ZW07XHJcbiAgd2lkdGg6IDEwMCU7XHJcbn1cclxuXHJcbi5idG4ge1xyXG4gIG1hcmdpbi1sZWZ0OiAwLjVlbTtcclxufVxyXG5cclxuLmhpZGRlbiB7XHJcbiAgZGlzcGxheTogbm9uZSAhaW1wb3J0YW50O1xyXG4gIHZpc2liaWxpdHk6IGhpZGRlbiAhaW1wb3J0YW50O1xyXG59XHJcblxyXG5cclxuLnNlYXJjaC1maWVsZCB7XHJcbiAgd2lkdGg6MTAwJTtcclxuICBtYXJnaW46IDA7XHJcbn1cclxuXHJcbi50YWItcHJvZ3Jlc3Mge1xyXG4gIG1hcmdpbi10b3A6IDFlbTtcclxufVxyXG5cclxuIl19 */"

/***/ }),

/***/ "./src/app/project-details/requirements-tab/requirements-tab.component.html":
/*!**********************************************************************************!*\
  !*** ./src/app/project-details/requirements-tab/requirements-tab.component.html ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"tab-progress\" *ngIf=\"uploadLoading\">\r\n  <ngb-progressbar type=\"primary\" [value]=\"100\" [striped]=\"true\" [animated]=\"true\">\r\n    <span>{{ progressMessage }}</span>\r\n  </ngb-progressbar>\r\n</div>\r\n\r\n\r\n<div class=\"row tab-header\">\r\n  <div class=\"col-10 pl-0\">\r\n    <div class=\"hidden\"><input type=\"file\" #fileInput (change)=\"fileChange($event)\"/></div>\r\n\r\n    <div class=\"btn-group\" role=\"group\" aria-label=\"Basic example\">\r\n      <button type=\"button\" class=\"btn btn-secondary\" (click)=\"disableSelected(false)\"\r\n              [disabled]=\"selected.length == 0\">\r\n        <i class=\"fa fa-check\"></i>&nbsp;Enable\r\n      </button>\r\n      <button type=\"button\" class=\"btn btn-secondary\" (click)=\"disableSelected(true)\"\r\n              [disabled]=\"selected.length == 0\">\r\n        <i class=\"fa fa-minus\"></i>&nbsp;Disable\r\n      </button>\r\n      <button type=\"button\" class=\"btn btn-secondary\" data-toggle=\"modal\" data-target=\"#deleteConfirmationModal\"\r\n              [disabled]=\"selected.length == 0\">\r\n        <i class=\"fa fa-trash\"></i>&nbsp;Delete\r\n      </button>\r\n    </div>\r\n\r\n\r\n    <a routerLink=\"/projects/{{projectId}}/addReq\">\r\n      <button type=\"button\" class=\"btn btn-outline-primary\" [disabled]=\"uploadLoading\">\r\n        <i class=\"fa fa-plus\" aria-hidden=\"true\"></i>\r\n        &nbsp;Add Requirement\r\n      </button>\r\n    </a>\r\n\r\n    <button type=\"button\" class=\"btn btn-outline-primary\" (click)=\"downloadRequirements()\">\r\n      <i class=\"fa fa-download\" aria-hidden=\"true\"></i>\r\n      &nbsp;Download Requirements\r\n    </button>\r\n\r\n    <button type=\"button\" class=\"btn btn-outline-primary\" (click)=\"fileInput.click()\"\r\n            [disabled]=\"uploadLoading\">\r\n      <i class=\"fa fa-upload\" aria-hidden=\"true\" *ngIf=\"!uploadLoading\"></i>\r\n      <i class='fa fa-spinner fa-spin' *ngIf=\"uploadLoading\"></i>\r\n      &nbsp;Upload File\r\n    </button>\r\n  </div>\r\n  <div class=\"col-2 pr-0\">\r\n\r\n    <input\r\n      type='text'\r\n      class=\"form-control search-field pull-right\"\r\n      placeholder='Search...'\r\n      (keyup)='updateFilter($event)'\r\n      [(ngModel)]=\"searchValue\"\r\n    />\r\n  </div>\r\n</div>\r\n\r\n\r\n<ngx-datatable #table\r\n  class=\"material\"\r\n  [columnMode]=\"'standard'\"\r\n  [headerHeight]=\"50\"\r\n  [footerHeight]=\"50\"\r\n  [rowHeight]=\"'auto'\"\r\n  [limit]=\"10\"\r\n  [selected]=\"selected\"\r\n  [selectionType]=\"'checkbox'\"\r\n  [rows]='rows'\r\n  [rowClass]=\"getRowClass\"\r\n  [reorderable]=\"true\"\r\n  (activate)=\"requirementDetails($event)\">\r\n  <ngx-datatable-column\r\n    [width]=\"30\"\r\n    [sortable]=\"false\"\r\n    [canAutoResize]=\"false\"\r\n    [draggable]=\"false\"\r\n    [resizeable]=\"false\"\r\n    [headerCheckboxable]=\"false\"\r\n    [checkboxable]=\"true\">\r\n  </ngx-datatable-column>\r\n  <ngx-datatable-column name=\"Id\" [width]=\"50\"></ngx-datatable-column>\r\n  <ngx-datatable-column name=\"Requirement\" prop=\"text\" [width]=\"1000\"></ngx-datatable-column>\r\n</ngx-datatable>\r\n\r\n<app-requirement-details [req]=\"selectedRequirement\" (update)=\"onChange($event)\"></app-requirement-details>\r\n\r\n<!-- Delete Confirmation Modal -->\r\n<div class=\"modal fade\" id=\"deleteConfirmationModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"deleteConfirmationModal\" aria-hidden=\"true\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Delete Confirmation</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        Are you sure you want to delete {{ selected.length }} requirements?\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\" (click)=\"deleteSelected()\">Delete</button>\r\n        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancel</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/project-details/requirements-tab/requirements-tab.component.ts":
/*!********************************************************************************!*\
  !*** ./src/app/project-details/requirements-tab/requirements-tab.component.ts ***!
  \********************************************************************************/
/*! exports provided: RequirementsTabComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RequirementsTabComponent", function() { return RequirementsTabComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_requirement__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../models/requirement */ "./src/app/models/requirement.ts");
/* harmony import */ var _services_requirement_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../services/requirement.service */ "./src/app/services/requirement.service.ts");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../alert/alert.service */ "./src/app/alert/alert.service.ts");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/release/index.js");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(_swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_4__);
/* harmony import */ var file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! file-saver/FileSaver */ "./node_modules/file-saver/FileSaver.js");
/* harmony import */ var file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_5__);
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var RequirementsTabComponent = /** @class */ (function () {
    function RequirementsTabComponent(requirementService, alertService) {
        this.requirementService = requirementService;
        this.alertService = alertService;
        this.selectedRequirement = new _models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]();
        this.uploadLoading = false;
        this.progressMessage = 'Loading...';
        this.searchValue = '';
        this.rows = [];
        this.selected = [];
    }
    RequirementsTabComponent.prototype.ngOnInit = function () {
        this.getRequirements();
    };
    RequirementsTabComponent.prototype.requirementDetails = function (event) {
        if (event.type === 'dblclick') {
            this.selectedRequirement = new _models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]().create(event.row);
        }
    };
    RequirementsTabComponent.prototype.onChange = function (req) {
        var index = this.requirements.findIndex(function (r) { return r.id === req.id; });
        if (index >= 0) {
            this.requirements[index] = req;
        }
        this.updateFilter(null);
    };
    RequirementsTabComponent.prototype.getRequirements = function () {
        var _this = this;
        this.requirementService.getRequirements(this.projectId).subscribe(function (requirements) {
            _this.requirements = requirements.map(function (req) { return new _models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]().create(req); });
            // console.log(this.requirements);
            _this.rows = _this.requirements;
        });
    };
    RequirementsTabComponent.prototype.fileChange = function (event) {
        var _this = this;
        var fileList = event.target.files;
        if (fileList.length > 0) {
            this.uploadLoading = true;
            this.requirementService.uploadFile(fileList[0], this.projectId).subscribe(function (data) {
                _this.uploadLoading = false;
                _this.requirements = _this.requirements.concat(data.map(function (req) { return new _models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]().create(req); }));
                _this.alertService.success('File uploaded correctly!');
            }, function (error) {
                _this.alertService.error('Error uploading the file!');
                console.error(error);
                _this.uploadLoading = false;
            });
        }
    };
    RequirementsTabComponent.prototype.getRowClass = function (req) {
        return {
            'row-green': req.compliant,
            'row-red': req.error,
            'row-yellow': req.notChecked,
            'row-disabled': req.disabled
        };
    };
    RequirementsTabComponent.prototype.disableSelected = function (disabled) {
        var _this = this;
        this.uploadLoading = true;
        var reqs = this.selected;
        var loaded = 0;
        reqs.forEach(function (req) {
            req.disabled = disabled;
            _this.requirementService.updateRequirement(req).subscribe(function (data) {
                loaded++;
                if (loaded === reqs.length) {
                    _this.uploadLoading = false;
                    _this.onChange(new _models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]().create(data));
                }
            }, function (error) { _this.alertService.error(error); });
        });
    };
    RequirementsTabComponent.prototype.deleteSelected = function () {
        var _this = this;
        this.uploadLoading = true;
        var reqs = this.selected;
        var loaded = 0;
        reqs.forEach(function (req) {
            _this.requirementService.deleteRequirement(req.id).subscribe(function (response) {
                var index = _this.requirements.findIndex(function (r) { return r.id === req.id; });
                if (index >= 0) {
                    _this.requirements.splice(index, 1);
                }
                loaded++;
                if (loaded === reqs.length) {
                    _this.uploadLoading = false;
                    _this.updateFilter(null);
                }
            }, function (error) {
                _this.alertService.error(error);
            });
        });
    };
    RequirementsTabComponent.prototype.updateFilter = function (event) {
        var val = this.searchValue.toLowerCase();
        // filter our data
        var temp = this.requirements.filter(function (req) {
            return req.text.toLowerCase().indexOf(val) !== -1 || !val;
        });
        // update the rows
        this.rows = temp;
        if (event != null) {
            // Whenever the filter changes, always go back to the first page
            this.table.offset = 0;
        }
        // Remove previously selected items
        this.selected = [];
    };
    RequirementsTabComponent.prototype.downloadRequirements = function () {
        var blob = new Blob([this.requirements.map(function (req) {
                if (!req.disabled) {
                    return '[' + req.id + ']' + req.text;
                }
            }).join('\n')], { type: 'text/plain' });
        Object(file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_5__["saveAs"])(blob, 'project-' + this.projectId + '-requirements');
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Number)
    ], RequirementsTabComponent.prototype, "projectId", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_4__["DatatableComponent"]),
        __metadata("design:type", _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_4__["DatatableComponent"])
    ], RequirementsTabComponent.prototype, "table", void 0);
    RequirementsTabComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-requirements-tab',
            template: __webpack_require__(/*! ./requirements-tab.component.html */ "./src/app/project-details/requirements-tab/requirements-tab.component.html"),
            styles: [__webpack_require__(/*! ./requirements-tab.component.css */ "./src/app/project-details/requirements-tab/requirements-tab.component.css")]
        }),
        __metadata("design:paramtypes", [_services_requirement_service__WEBPACK_IMPORTED_MODULE_2__["RequirementService"],
            _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__["AlertService"]])
    ], RequirementsTabComponent);
    return RequirementsTabComponent;
}());



/***/ }),

/***/ "./src/app/project-details/tasks-tab/tasks-tab.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/project-details/tasks-tab/tasks-tab.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".tab-header {\r\n  margin-top: 1em;\r\n  margin-bottom: 1em;\r\n}\r\n\r\n.btn {\r\n  margin-left: 0.5em;\r\n}\r\n\r\n.card {\r\n  margin-bottom: 1em;\r\n}\r\n\r\n.status-success {\r\n  color: #469408;\r\n}\r\n\r\n.status-fail {\r\n  color: #D9230F;\r\n}\r\n\r\n.status-running {\r\n  color: #469408;\r\n  -webkit-animation: blinker 1s linear infinite;\r\n          animation: blinker 1s linear infinite;\r\n}\r\n\r\n@-webkit-keyframes blinker {\r\n  50% { opacity: 0.0; }\r\n}\r\n\r\n@keyframes blinker {\r\n  50% { opacity: 0.0; }\r\n}\r\n\r\n.fa-bars {\r\n  cursor: move;\r\n}\r\n\r\n.cdk-drag-preview {\r\n  box-sizing: border-box;\r\n  border-radius: 4px;\r\n  box-shadow: 0 5px 5px -3px rgba(0, 0, 0, 0.2),\r\n  0 8px 10px 1px rgba(0, 0, 0, 0.14),\r\n  0 3px 14px 2px rgba(0, 0, 0, 0.12);\r\n}\r\n\r\n.cdk-drag-placeholder {\r\n  opacity: 0;\r\n}\r\n\r\n.cdk-drag-animating {\r\n  -webkit-transition: -webkit-transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n  transition: -webkit-transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n  transition: transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n  transition: transform 250ms cubic-bezier(0, 0, 0.2, 1), -webkit-transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n}\r\n\r\n.example-list.cdk-drop-list-dragging .example-box:not(.cdk-drag-placeholder) {\r\n  -webkit-transition: -webkit-transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n  transition: -webkit-transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n  transition: transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n  transition: transform 250ms cubic-bezier(0, 0, 0.2, 1), -webkit-transform 250ms cubic-bezier(0, 0, 0.2, 1);\r\n}\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvamVjdC1kZXRhaWxzL3Rhc2tzLXRhYi90YXNrcy10YWIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGVBQWU7RUFDZixrQkFBa0I7QUFDcEI7O0FBRUE7RUFDRSxrQkFBa0I7QUFDcEI7O0FBRUE7RUFDRSxrQkFBa0I7QUFDcEI7O0FBRUE7RUFDRSxjQUFjO0FBQ2hCOztBQUVBO0VBQ0UsY0FBYztBQUNoQjs7QUFFQTtFQUNFLGNBQWM7RUFDZCw2Q0FBcUM7VUFBckMscUNBQXFDO0FBQ3ZDOztBQUVBO0VBQ0UsTUFBTSxZQUFZLEVBQUU7QUFDdEI7O0FBRkE7RUFDRSxNQUFNLFlBQVksRUFBRTtBQUN0Qjs7QUFJQTtFQUNFLFlBQVk7QUFDZDs7QUFFQTtFQUNFLHNCQUFzQjtFQUN0QixrQkFBa0I7RUFDbEI7O29DQUVrQztBQUNwQzs7QUFFQTtFQUNFLFVBQVU7QUFDWjs7QUFFQTtFQUNFLHNFQUFzRDtFQUF0RCw4REFBc0Q7RUFBdEQsc0RBQXNEO0VBQXRELDBHQUFzRDtBQUN4RDs7QUFFQTtFQUNFLHNFQUFzRDtFQUF0RCw4REFBc0Q7RUFBdEQsc0RBQXNEO0VBQXRELDBHQUFzRDtBQUN4RCIsImZpbGUiOiJzcmMvYXBwL3Byb2plY3QtZGV0YWlscy90YXNrcy10YWIvdGFza3MtdGFiLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIudGFiLWhlYWRlciB7XHJcbiAgbWFyZ2luLXRvcDogMWVtO1xyXG4gIG1hcmdpbi1ib3R0b206IDFlbTtcclxufVxyXG5cclxuLmJ0biB7XHJcbiAgbWFyZ2luLWxlZnQ6IDAuNWVtO1xyXG59XHJcblxyXG4uY2FyZCB7XHJcbiAgbWFyZ2luLWJvdHRvbTogMWVtO1xyXG59XHJcblxyXG4uc3RhdHVzLXN1Y2Nlc3Mge1xyXG4gIGNvbG9yOiAjNDY5NDA4O1xyXG59XHJcblxyXG4uc3RhdHVzLWZhaWwge1xyXG4gIGNvbG9yOiAjRDkyMzBGO1xyXG59XHJcblxyXG4uc3RhdHVzLXJ1bm5pbmcge1xyXG4gIGNvbG9yOiAjNDY5NDA4O1xyXG4gIGFuaW1hdGlvbjogYmxpbmtlciAxcyBsaW5lYXIgaW5maW5pdGU7XHJcbn1cclxuXHJcbkBrZXlmcmFtZXMgYmxpbmtlciB7XHJcbiAgNTAlIHsgb3BhY2l0eTogMC4wOyB9XHJcbn1cclxuXHJcblxyXG5cclxuLmZhLWJhcnMge1xyXG4gIGN1cnNvcjogbW92ZTtcclxufVxyXG5cclxuLmNkay1kcmFnLXByZXZpZXcge1xyXG4gIGJveC1zaXppbmc6IGJvcmRlci1ib3g7XHJcbiAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gIGJveC1zaGFkb3c6IDAgNXB4IDVweCAtM3B4IHJnYmEoMCwgMCwgMCwgMC4yKSxcclxuICAwIDhweCAxMHB4IDFweCByZ2JhKDAsIDAsIDAsIDAuMTQpLFxyXG4gIDAgM3B4IDE0cHggMnB4IHJnYmEoMCwgMCwgMCwgMC4xMik7XHJcbn1cclxuXHJcbi5jZGstZHJhZy1wbGFjZWhvbGRlciB7XHJcbiAgb3BhY2l0eTogMDtcclxufVxyXG5cclxuLmNkay1kcmFnLWFuaW1hdGluZyB7XHJcbiAgdHJhbnNpdGlvbjogdHJhbnNmb3JtIDI1MG1zIGN1YmljLWJlemllcigwLCAwLCAwLjIsIDEpO1xyXG59XHJcblxyXG4uZXhhbXBsZS1saXN0LmNkay1kcm9wLWxpc3QtZHJhZ2dpbmcgLmV4YW1wbGUtYm94Om5vdCguY2RrLWRyYWctcGxhY2Vob2xkZXIpIHtcclxuICB0cmFuc2l0aW9uOiB0cmFuc2Zvcm0gMjUwbXMgY3ViaWMtYmV6aWVyKDAsIDAsIDAuMiwgMSk7XHJcbn1cclxuXHJcbiJdfQ== */"

/***/ }),

/***/ "./src/app/project-details/tasks-tab/tasks-tab.component.html":
/*!********************************************************************!*\
  !*** ./src/app/project-details/tasks-tab/tasks-tab.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"tab-header clearfix\">\r\n  <button type=\"button\" class=\"btn btn-primary pull-right\" [disabled]=\"codeLoading\" (click)=\"getCode()\">\r\n    <i class=\"fa fa-play\" aria-hidden=\"true\" *ngIf=\"!codeLoading\"></i>\r\n    <i class='fa fa-spinner fa-spin' *ngIf=\"codeLoading\"></i>\r\n    &nbsp;Generate\r\n  </button>\r\n\r\n  <button type=\"button\" *ngIf=\"task.generate\" class=\"btn btn-primary pull-right\" (click)=\"downloadCode()\">\r\n    <i class=\"fa fa-download\" aria-hidden=\"true\"></i>\r\n     Download Code\r\n  </button>\r\n\r\n  <button type=\"button\" *ngIf=\"task.generate\" class=\"btn btn-primary pull-right\" (click)=\"downloadRequirements()\">\r\n    <i class=\"fa fa-download\" aria-hidden=\"true\"></i>\r\n    Download Requirements\r\n  </button>\r\n\r\n</div>\r\n<div *ngIf=\"task !== null\">\r\n  <div class=\"card\" *ngIf=\"task.generate\">\r\n    <div class=\"card-body\">\r\n        <h4 class=\"card-title\">{{task.description}}</h4>\r\n\r\n      <h6 class=\"card-subtitle mb-2 text-muted\">{{task.timestamp}}</h6>\r\n\r\n      <div class=\"card-text\">\r\n        <div>\r\n          <textarea class=\"form-control\" readonly=\"readonly\" rows=\"15\">{{task.code}}</textarea>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n  <div *ngIf=\"task.priority\">\r\n    <div *ngFor=\"let reqArr of reqArray; index as i\">\r\n      <div class=\"card mt-5\" *ngIf=\"!isHidden[i]\" [@hiddenDisplay]>\r\n        <h4 class=\"card-header\">{{task.description}}\r\n<!--          <small><i class=\"fa fa-info-circle\" data-toggle=\"tooltip\" data-placement=\"right\"-->\r\n<!--                    title=\"越靠前的规约优先级越高\"></i></small>-->\r\n        </h4>\r\n        <div class=\"card-body\">\r\n\r\n          <div class=\"card-text\">\r\n            <ul class=\"list-group\">\r\n                <li class=\"list-group-item\" *ngFor=\"let req of reqArr; index as i\">\r\n                  {{ req[1].id + \": \" + req[1].text }}\r\n                  <input class=\"form-control pull-right\" style=\"width: 60px; height: 25px;\" [(ngModel)]=\"req[2]\">\r\n                </li>\r\n            </ul>\r\n          </div>\r\n          <button type=\"button\" class=\"btn btn-primary pull-right mt-3\" [disabled]=\"priorityLoading\" (click)=\"updatePriority(i)\">\r\n            <i class=\"fa fa-upload\" aria-hidden=\"true\" *ngIf=\"!priorityLoading\"></i>\r\n            <i class='fa fa-spinner fa-spin' *ngIf=\"priorityLoading\"></i>\r\n            Confirm\r\n          </button>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n  <div *ngIf=\"task.circular\">\r\n    <div *ngFor=\"let reqArr of circularDependencyReqArray; index as i\">\r\n      <div class=\"card mt-5\">\r\n        <h4 class=\"card-header\">{{task.description}}\r\n        </h4>\r\n        <div class=\"card-body\">\r\n          <div class=\"card-text\">\r\n            <ul class=\"list-group\">\r\n              <li class=\"list-group-item\" *ngFor=\"let req of reqArr\">\r\n                {{ req }}\r\n              </li>\r\n            </ul>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n"

/***/ }),

/***/ "./src/app/project-details/tasks-tab/tasks-tab.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/project-details/tasks-tab/tasks-tab.component.ts ***!
  \******************************************************************/
/*! exports provided: TasksTabComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TasksTabComponent", function() { return TasksTabComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_task_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../services/task.service */ "./src/app/services/task.service.ts");
/* harmony import */ var _models_task__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../models/task */ "./src/app/models/task.ts");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../alert/alert.service */ "./src/app/alert/alert.service.ts");
/* harmony import */ var file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! file-saver/FileSaver */ "./node_modules/file-saver/FileSaver.js");
/* harmony import */ var file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_4__);
/* harmony import */ var _services_requirement_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../services/requirement.service */ "./src/app/services/requirement.service.ts");
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var TasksTabComponent = /** @class */ (function () {
    function TasksTabComponent(taskService, alertService, requirementService) {
        this.taskService = taskService;
        this.alertService = alertService;
        this.requirementService = requirementService;
        this.codeLoading = false;
        this.priorityLoading = false;
    }
    TasksTabComponent.prototype.ngOnInit = function () {
        this.task = new _models_task__WEBPACK_IMPORTED_MODULE_2__["Task"]({ priority: false, generate: false, conflict: false });
        this.finishedTask();
    };
    // drop(event: CdkDragDrop<string[]>, index: number) {
    //   moveItemInArray(this.reqArray[index], event.previousIndex, event.currentIndex);
    //   moveItemInArray(this.priorityArray[index], event.previousIndex, event.currentIndex);
    // }
    TasksTabComponent.prototype.finishedTask = function () {
        var _this = this;
        this.taskService.getFinishedTask(this.projectId).subscribe(function (response) {
            if (response !== null && (response.status === 200 || response.status === 201)) {
                if (response.body !== null) {
                    _this.task = new _models_task__WEBPACK_IMPORTED_MODULE_2__["Task"](response.body);
                }
            }
        }, function (error) {
            _this.alertService.error(error);
        });
    };
    TasksTabComponent.prototype.getObject = function (req) {
        return req.text.split(',').pop().trim().split(' ')[0];
    };
    TasksTabComponent.prototype.showPriority = function () {
        var _this = this;
        this.priorityArray = new Array(this.task.priorityArray.length)
            .fill(null)
            .map(function (val, index) { return _this.task.priorityArray[index].split('<').map(function (id) { return Number(id); }); });
        this.isHidden = new Array(this.task.priorityArray.length).fill(false);
        this.reqArray = new Array(this.task.priorityArray.length);
        var _loop_1 = function (i) {
            this_1.reqArray[i] = new Array(this_1.priorityArray[i].length);
            var _loop_2 = function (j) {
                this_1.requirementService.getRequirement(this_1.priorityArray[i][j]).subscribe(function (req) {
                    _this.reqArray[i][j] = [_this.priorityArray[i][j], req, ''];
                });
            };
            for (var j = 0; j < this_1.priorityArray[i].length; j++) {
                _loop_2(j);
            }
        };
        var this_1 = this;
        for (var i = 0; i < this.priorityArray.length; i++) {
            _loop_1(i);
        }
    };
    TasksTabComponent.prototype.showCircularDependencyArray = function () {
        var _this = this;
        var arr = this.task.circularDependencyArray.map(function (elem) { return elem.split(','); });
        this.circularDependencyReqArray = new Array(arr.length);
        var _loop_3 = function (i) {
            this_2.circularDependencyReqArray[i] = new Array(arr[i].length);
            var _loop_4 = function (j) {
                this_2.requirementService.getRequirement(Number(arr[i][j])).subscribe(function (req) { return _this.circularDependencyReqArray[i][j] = req.text; });
            };
            for (var j = 0; j < arr[i].length; j++) {
                _loop_4(j);
            }
        };
        var this_2 = this;
        for (var i = 0; i < arr.length; i++) {
            _loop_3(i);
        }
    };
    TasksTabComponent.prototype.getCode = function () {
        var _this = this;
        this.codeLoading = true;
        this.taskService.getTask(this.projectId).subscribe(function (response) {
            _this.task = new _models_task__WEBPACK_IMPORTED_MODULE_2__["Task"](response);
            console.log(_this.task);
            if (_this.task.priority) {
                _this.showPriority();
            }
            else if (_this.task.circular) {
                _this.showCircularDependencyArray();
            }
            _this.codeLoading = false;
        }, function (error) {
            _this.alertService.error(error);
            _this.codeLoading = false;
        });
    };
    TasksTabComponent.prototype.updatePriority = function (index) {
        var _this = this;
        this.isHidden[index] = true;
        if (this.isHidden.every(function (val) { return val === true; })) {
            this.codeLoading = true;
            var _loop_5 = function (i) {
                this_3.priorityArray[i].sort(function (a, b) {
                    return parseFloat(_this.reqArray[i].find(function (elem) { return elem[0] === a; })[2])
                        - parseFloat(_this.reqArray[i].find(function (elem) { return elem[0] === b; })[2]);
                });
            };
            var this_3 = this;
            for (var i = 0; i < this.priorityArray.length; i++) {
                _loop_5(i);
            }
            this.task.priorityArray = this.priorityArray.map(function (arr) { return arr.join('<'); });
            this.taskService.postTask(this.task).subscribe(function (response) {
                _this.task = new _models_task__WEBPACK_IMPORTED_MODULE_2__["Task"](response);
                _this.codeLoading = false;
            }, function (error) {
                _this.alertService.error(error);
                _this.codeLoading = false;
            });
        }
    };
    TasksTabComponent.prototype.downloadCode = function () {
        var blob = new Blob([this.task.code], { type: 'text/plain' });
        Object(file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_4__["saveAs"])(blob, this.task.timestamp.replace(/ |:/g, '-') + '-ILCode');
    };
    TasksTabComponent.prototype.downloadRequirements = function () {
        var blob = new Blob([this.task.requirements], { type: 'text/plain' });
        Object(file_saver_FileSaver__WEBPACK_IMPORTED_MODULE_4__["saveAs"])(blob, this.task.timestamp.replace(/ |:/g, '-') + '-Requirements');
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Number)
    ], TasksTabComponent.prototype, "projectId", void 0);
    TasksTabComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-tasks-tab',
            template: __webpack_require__(/*! ./tasks-tab.component.html */ "./src/app/project-details/tasks-tab/tasks-tab.component.html"),
            animations: [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["trigger"])('hiddenDisplay', [
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["transition"])(':enter', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({ opacity: 0 }),
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["animate"])('300ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({ 'opacity': 1 }))
                    ]),
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["transition"])(':leave', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({ 'opacity': 1 }),
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["animate"])('300ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_6__["style"])({ 'opacity': 0 }))
                    ])
                ])
            ],
            styles: [__webpack_require__(/*! ./tasks-tab.component.css */ "./src/app/project-details/tasks-tab/tasks-tab.component.css")]
        }),
        __metadata("design:paramtypes", [_services_task_service__WEBPACK_IMPORTED_MODULE_1__["TaskService"],
            _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__["AlertService"],
            _services_requirement_service__WEBPACK_IMPORTED_MODULE_5__["RequirementService"]])
    ], TasksTabComponent);
    return TasksTabComponent;
}());



/***/ }),

/***/ "./src/app/project-dialog/project-dialog.component.html":
/*!**************************************************************!*\
  !*** ./src/app/project-dialog/project-dialog.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#newProjectModal\">New Project</button>\r\n</div>\r\n\r\n<!-- Modal -->\r\n<div class=\"modal fade\" tabindex=\"-1\" id=\"newProjectModal\" role=\"dialog\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">New Project</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <form [formGroup]=\"newProjectForm\">\r\n        <div class=\"modal-body\">\r\n          <div class=\"form-group\">\r\n            <label class=\"form-control-label\" for=\"project-name\">Name</label>\r\n            <input class=\"form-control\" id=\"project-name\" type=\"text\" formControlName=\"name\"\r\n                   [ngClass]=\"{'is-valid': name.valid, 'is-invalid': !(name.valid || name.pristine)}\">\r\n            <div [hidden]=\"name.valid || name.pristine\"\r\n                 class=\"alert alert-danger\">\r\n              Name must be at least 3 characters long\r\n            </div>\r\n          </div>\r\n          <div class=\"form-group\">\r\n            <label for=\"project-description\">Description</label>\r\n            <textarea class=\"form-control\"\r\n                      id=\"project-description\"\r\n                      rows=\"2\"\r\n                      formControlName=\"description\">\r\n            </textarea>\r\n          </div>\r\n        </div>\r\n        <div class=\"modal-footer\">\r\n          <button type=\"submit\" class=\"btn btn-primary\" [disabled]=\"!newProjectForm.valid || loading\" (click)=\"createProject()\">\r\n            <i class=\"fa fa-spinner fa-spin\" aria-hidden=\"true\" *ngIf=\"loading\">&nbsp;</i>Save\r\n          </button>\r\n          <button type=\"reset\" class=\"btn btn-secondary\" data-dismiss=\"modal\" (click)=\"reset()\" #closeBtn>Close</button>\r\n        </div>\r\n      </form>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/project-dialog/project-dialog.component.ts":
/*!************************************************************!*\
  !*** ./src/app/project-dialog/project-dialog.component.ts ***!
  \************************************************************/
/*! exports provided: ProjectDialogComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectDialogComponent", function() { return ProjectDialogComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_project__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../models/project */ "./src/app/models/project.ts");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../alert/alert.service */ "./src/app/alert/alert.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ProjectDialogComponent = /** @class */ (function () {
    function ProjectDialogComponent(fb, projectService, alertService) {
        this.fb = fb;
        this.projectService = projectService;
        this.alertService = alertService;
        this.project = new _models_project__WEBPACK_IMPORTED_MODULE_1__["Project"](null, '', '');
        this.loading = false;
        this.createForm();
    }
    ProjectDialogComponent.prototype.ngOnInit = function () {
    };
    ProjectDialogComponent.prototype.createForm = function () {
        this.newProjectForm = this.fb.group({
            name: new _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormControl"](this.project.name, [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required, _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].minLength(3)]),
            description: new _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormControl"](this.project.description)
        });
    };
    Object.defineProperty(ProjectDialogComponent.prototype, "name", {
        get: function () { return this.newProjectForm.get('name'); },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ProjectDialogComponent.prototype, "description", {
        get: function () { return this.newProjectForm.get('description'); },
        enumerable: true,
        configurable: true
    });
    ProjectDialogComponent.prototype.reset = function () {
        this.newProjectForm.reset();
    };
    ProjectDialogComponent.prototype.createProject = function () {
        var _this = this;
        this.loading = true;
        var formModel = this.newProjectForm.value;
        this.project.name = formModel.name;
        this.project.description = formModel.description;
        this.projectService.createProject(this.project).subscribe(function (response) {
            if (response.status === 200 || response.status === 201) {
                _this.alertService.success('New Project created successfully!');
            }
            else {
                console.log(response);
                _this.alertService.error('Error creating the new project!');
            }
            _this.closeBtn.nativeElement.click();
            _this.loading = false;
        }, function (error) {
            _this.alertService.error('Error creating the new project!');
            _this.loading = false;
        });
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])('closeBtn'),
        __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"])
    ], ProjectDialogComponent.prototype, "closeBtn", void 0);
    ProjectDialogComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-dialog',
            template: __webpack_require__(/*! ./project-dialog.component.html */ "./src/app/project-dialog/project-dialog.component.html")
        }),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"],
            _services_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"],
            _alert_alert_service__WEBPACK_IMPORTED_MODULE_4__["AlertService"]])
    ], ProjectDialogComponent);
    return ProjectDialogComponent;
}());



/***/ }),

/***/ "./src/app/projects/delete-project-modal/delete-project-modal.component.css":
/*!**********************************************************************************!*\
  !*** ./src/app/projects/delete-project-modal/delete-project-modal.component.css ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3Byb2plY3RzL2RlbGV0ZS1wcm9qZWN0LW1vZGFsL2RlbGV0ZS1wcm9qZWN0LW1vZGFsLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/projects/delete-project-modal/delete-project-modal.component.html":
/*!***********************************************************************************!*\
  !*** ./src/app/projects/delete-project-modal/delete-project-modal.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!-- The Modal-->\n<div class=\"modal fade\" id=\"deleteModal\">\n  <div class=\"modal-dialog\">\n    <div class=\"modal-content\">\n      <div class=\"modal-header\">\n        <h4 class=\"modal-title\">{{ project.name }}</h4>\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n      </div>\n\n      <div class=\"modal-body\">\n        Are you sure you want to delete this project?\n      </div>\n\n      <div class=\"modal-footer\">\n        <button class=\"btn btn-danger\" data-dismiss=\"modal\" (click)=\"confirm.emit()\">Delete</button>\n        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancel</button>\n      </div>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/projects/delete-project-modal/delete-project-modal.component.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/projects/delete-project-modal/delete-project-modal.component.ts ***!
  \*********************************************************************************/
/*! exports provided: DeleteProjectModalComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DeleteProjectModalComponent", function() { return DeleteProjectModalComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_project__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../models/project */ "./src/app/models/project.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var DeleteProjectModalComponent = /** @class */ (function () {
    function DeleteProjectModalComponent() {
        this.confirm = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
    }
    DeleteProjectModalComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", _models_project__WEBPACK_IMPORTED_MODULE_1__["Project"])
    ], DeleteProjectModalComponent.prototype, "project", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], DeleteProjectModalComponent.prototype, "confirm", void 0);
    DeleteProjectModalComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-delete-project-modal',
            template: __webpack_require__(/*! ./delete-project-modal.component.html */ "./src/app/projects/delete-project-modal/delete-project-modal.component.html"),
            styles: [__webpack_require__(/*! ./delete-project-modal.component.css */ "./src/app/projects/delete-project-modal/delete-project-modal.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], DeleteProjectModalComponent);
    return DeleteProjectModalComponent;
}());



/***/ }),

/***/ "./src/app/projects/projects.component.css":
/*!*************************************************!*\
  !*** ./src/app/projects/projects.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#projects-container {\r\n  margin-top: 2em;\r\n  margin-bottom: 2em;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvamVjdHMvcHJvamVjdHMuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGVBQWU7RUFDZixrQkFBa0I7QUFDcEIiLCJmaWxlIjoic3JjL2FwcC9wcm9qZWN0cy9wcm9qZWN0cy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiI3Byb2plY3RzLWNvbnRhaW5lciB7XHJcbiAgbWFyZ2luLXRvcDogMmVtO1xyXG4gIG1hcmdpbi1ib3R0b206IDJlbTtcclxufVxyXG4iXX0= */"

/***/ }),

/***/ "./src/app/projects/projects.component.html":
/*!**************************************************!*\
  !*** ./src/app/projects/projects.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h1>Your Projects</h1>\r\n\r\n<div id=\"projects-container\">\r\n\r\n  <div *ngIf=\"loading\">\r\n    <i class='fa fa-spinner fa-spin'></i> Loading...\r\n  </div>\r\n\r\n  <div *ngIf=\"!loading && projects.length == 0\">\r\n    You don't have any project yet, create one!\r\n  </div>\r\n\r\n  <div class=\"row\">\r\n    <div class=\"col-md-4\" *ngFor=\"let project of projects\">\r\n      <div class=\"card border-primary mb-3\" >\r\n        <div class=\"card-body text-dark\">\r\n          <a routerLink=\"/projects/{{project.id}}\">\r\n            <h4 class=\"card-title\">{{ project.name }}</h4>\r\n          </a>\r\n          <p class=\"card-text\">{{ project.description }}</p>\r\n          <button class=\"btn btn-danger\" data-toggle=\"modal\" (click)=\"select(project)\" data-target=\"#deleteModal\"><i class=\"fa fa-trash\"></i> Delete</button>\r\n          <app-delete-project-modal [project]=\"getSelectedProject()\" (confirm)=\"deleteSelectedProject()\"></app-delete-project-modal>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n</div>\r\n\r\n<app-project-dialog></app-project-dialog>\r\n\r\n\r\n"

/***/ }),

/***/ "./src/app/projects/projects.component.ts":
/*!************************************************!*\
  !*** ./src/app/projects/projects.component.ts ***!
  \************************************************/
/*! exports provided: ProjectsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectsComponent", function() { return ProjectsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");
/* harmony import */ var _models_project__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../models/project */ "./src/app/models/project.ts");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../alert/alert.service */ "./src/app/alert/alert.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ProjectsComponent = /** @class */ (function () {
    function ProjectsComponent(projectService, alertService) {
        this.projectService = projectService;
        this.alertService = alertService;
        this.selectedProject = new _models_project__WEBPACK_IMPORTED_MODULE_2__["Project"](null, '', '');
        this.loading = true;
    }
    ProjectsComponent.prototype.ngOnInit = function () {
        this.getProjects();
    };
    ProjectsComponent.prototype.getProjects = function () {
        var _this = this;
        this.projectService.getProjects().subscribe(function (projects) {
            _this.projects = projects;
            _this.loading = false;
        });
    };
    ProjectsComponent.prototype.deleteProject = function (project) {
        this.projects = this.projects.filter(function (proj) { return proj !== project; });
        this.alertService.success('Project deleted successfully!');
        this.projectService.deleteProject(project).subscribe();
    };
    ProjectsComponent.prototype.select = function (project) {
        this.selectedProject = project;
    };
    ProjectsComponent.prototype.getSelectedProject = function () {
        return this.selectedProject;
    };
    ProjectsComponent.prototype.deleteSelectedProject = function () {
        this.deleteProject(this.selectedProject);
    };
    ProjectsComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-projects',
            template: __webpack_require__(/*! ./projects.component.html */ "./src/app/projects/projects.component.html"),
            styles: [__webpack_require__(/*! ./projects.component.css */ "./src/app/projects/projects.component.css")]
        }),
        __metadata("design:paramtypes", [_services_project_service__WEBPACK_IMPORTED_MODULE_1__["ProjectService"],
            _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__["AlertService"]])
    ], ProjectsComponent);
    return ProjectsComponent;
}());



/***/ }),

/***/ "./src/app/requirement-details/requirement-details.component.css":
/*!***********************************************************************!*\
  !*** ./src/app/requirement-details/requirement-details.component.css ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".badge-green {\r\n  color: #fff;\r\n  background-color: #469408;\r\n}\r\n\r\n.badge-yellow {\r\n  color: #fff;\r\n  background-color: #D9831F;\r\n}\r\n\r\n.badge-red {\r\n  color: #fff;\r\n  background-color: #D9230F;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcmVxdWlyZW1lbnQtZGV0YWlscy9yZXF1aXJlbWVudC1kZXRhaWxzLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxXQUFXO0VBQ1gseUJBQXlCO0FBQzNCOztBQUVBO0VBQ0UsV0FBVztFQUNYLHlCQUF5QjtBQUMzQjs7QUFJQTtFQUNFLFdBQVc7RUFDWCx5QkFBeUI7QUFDM0IiLCJmaWxlIjoic3JjL2FwcC9yZXF1aXJlbWVudC1kZXRhaWxzL3JlcXVpcmVtZW50LWRldGFpbHMuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5iYWRnZS1ncmVlbiB7XHJcbiAgY29sb3I6ICNmZmY7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogIzQ2OTQwODtcclxufVxyXG5cclxuLmJhZGdlLXllbGxvdyB7XHJcbiAgY29sb3I6ICNmZmY7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogI0Q5ODMxRjtcclxufVxyXG5cclxuXHJcblxyXG4uYmFkZ2UtcmVkIHtcclxuICBjb2xvcjogI2ZmZjtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjRDkyMzBGO1xyXG59XHJcbiJdfQ== */"

/***/ }),

/***/ "./src/app/requirement-details/requirement-details.component.html":
/*!************************************************************************!*\
  !*** ./src/app/requirement-details/requirement-details.component.html ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<button #openModalBtn [hidden]=\"true\" data-toggle=\"modal\" data-target=\"#reqDetailsModal\">Open Modal</button>\r\n\r\n<div class=\"modal fade\" id=\"reqDetailsModal\" *ngIf=\"requirement\">\r\n  <div class=\"modal-dialog\" role=\"document\">\r\n    <div class=\"modal-content\">\r\n      <div class=\"modal-header\">\r\n        <h5 class=\"modal-title\">Edit Requirement</h5>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n          <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n      </div>\r\n      <div class=\"modal-body\">\r\n        <div class=\"form-group\">\r\n          <label for=\"reqTextarea\">Requirement</label>\r\n          <textarea class=\"form-control\" id=\"reqTextarea\" rows=\"2\"\r\n                    #reqTextarea (click)=\"getCaretPos(reqTextarea)\" (keyup)=\"getCaretPos(reqTextarea)\"\r\n                    [(ngModel)]=\"requirement.text\" ></textarea>\r\n          <p class=\"small pull-right\">line {{caretPos[0]}}:{{caretPos[1]}}</p>\r\n        </div>\r\n\r\n        <div class=\"form-group\">\r\n          <label for=\"stateBadge\">State</label>\r\n          <p id=\"stateBadge\"><span class=\"badge\"\r\n            [ngClass]=\"{'badge-green': requirement.compliant,\r\n                        'badge-yellow': requirement.notChecked,\r\n                        'badge-red': requirement.error}\">{{ requirement.state }}</span></p>\r\n        </div>\r\n\r\n        <div class=\"form-group\">\r\n          <label for=\"errorTextarea\">Error</label>\r\n          <textarea class=\"form-control\" id=\"errorTextarea\" disabled>{{ requirement.errorDescription }}</textarea>\r\n        </div>\r\n      </div>\r\n      <div class=\"modal-footer\">\r\n        <button class=\"btn btn-primary\" (click)=\"save()\" #saveBtn [disabled]=\"loading\">\r\n          <i class=\"fa fa-spinner fa-spin\" aria-hidden=\"true\" *ngIf=\"loading\">&nbsp;</i>Save\r\n        </button>\r\n        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" #closeBtn>Close</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/requirement-details/requirement-details.component.ts":
/*!**********************************************************************!*\
  !*** ./src/app/requirement-details/requirement-details.component.ts ***!
  \**********************************************************************/
/*! exports provided: RequirementDetailsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RequirementDetailsComponent", function() { return RequirementDetailsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _models_requirement__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../models/requirement */ "./src/app/models/requirement.ts");
/* harmony import */ var _services_requirement_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/requirement.service */ "./src/app/services/requirement.service.ts");
/* harmony import */ var _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../alert/alert.service */ "./src/app/alert/alert.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var RequirementDetailsComponent = /** @class */ (function () {
    function RequirementDetailsComponent(requirementService, alertService) {
        this.requirementService = requirementService;
        this.alertService = alertService;
        this.update = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.loading = false;
        this.caretPos = [1, 1];
    }
    RequirementDetailsComponent.prototype.ngOnInit = function () {
    };
    Object.defineProperty(RequirementDetailsComponent.prototype, "req", {
        set: function (req) {
            if (req) {
                this.requirement = req;
                this.openModalBtn.nativeElement.click();
            }
        },
        enumerable: true,
        configurable: true
    });
    RequirementDetailsComponent.prototype.save = function () {
        var _this = this;
        this.loading = true;
        this.requirementService.updateRequirement(this.requirement).subscribe(function (data) {
            _this.loading = false;
            _this.update.emit(new _models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]().create(data));
            _this.closeBtn.nativeElement.click();
        }, function (error) {
            _this.loading = false;
            console.error(error);
            _this.alertService.error('Error during requirement update, try again.');
        });
    };
    RequirementDetailsComponent.prototype.getCaretPos = function (oField) {
        if (!isNaN(oField.selectionStart)) {
            var i = this.requirement.text.indexOf('\n', 0);
            var j = 0;
            var row = 1;
            while (i >= 0 && i < oField.selectionStart) {
                j = i + 1;
                i = this.requirement.text.indexOf('\n', i + 1);
                ++row;
            }
            this.caretPos[0] = row;
            this.caretPos[1] = oField.selectionStart - j;
        }
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"])(),
        __metadata("design:type", Object)
    ], RequirementDetailsComponent.prototype, "update", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])('openModalBtn'),
        __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"])
    ], RequirementDetailsComponent.prototype, "openModalBtn", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])('closeBtn'),
        __metadata("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"])
    ], RequirementDetailsComponent.prototype, "closeBtn", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", _models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]),
        __metadata("design:paramtypes", [_models_requirement__WEBPACK_IMPORTED_MODULE_1__["Requirement"]])
    ], RequirementDetailsComponent.prototype, "req", null);
    RequirementDetailsComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-requirement-details',
            template: __webpack_require__(/*! ./requirement-details.component.html */ "./src/app/requirement-details/requirement-details.component.html"),
            styles: [__webpack_require__(/*! ./requirement-details.component.css */ "./src/app/requirement-details/requirement-details.component.css")]
        }),
        __metadata("design:paramtypes", [_services_requirement_service__WEBPACK_IMPORTED_MODULE_2__["RequirementService"],
            _alert_alert_service__WEBPACK_IMPORTED_MODULE_3__["AlertService"]])
    ], RequirementDetailsComponent);
    return RequirementDetailsComponent;
}());



/***/ }),

/***/ "./src/app/services/authentication.service.ts":
/*!****************************************************!*\
  !*** ./src/app/services/authentication.service.ts ***!
  \****************************************************/
/*! exports provided: CURRENT_USER, AuthenticationService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CURRENT_USER", function() { return CURRENT_USER; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function() { return AuthenticationService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _auth0_angular_jwt__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @auth0/angular-jwt */ "./node_modules/@auth0/angular-jwt/index.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var CURRENT_USER = 'currentUser';
var AuthenticationService = /** @class */ (function () {
    function AuthenticationService(http) {
        this.http = http;
        this.jwtHelper = new _auth0_angular_jwt__WEBPACK_IMPORTED_MODULE_2__["JwtHelperService"]();
    }
    AuthenticationService.prototype.login = function (username, password) {
        var _this = this;
        return new rxjs__WEBPACK_IMPORTED_MODULE_3__["Observable"](function (subscriber) {
            return _this.http.post('api/login', { username: username, password: password }, {
                headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]().set('Content-Type', 'application/json'),
                observe: 'response',
            })
                .subscribe(function (response) {
                console.log(response);
                localStorage.setItem(CURRENT_USER, response.headers.get('Authorization'));
                subscriber.next(response);
            }, function (error) { return subscriber.error(error); });
        });
    };
    AuthenticationService.prototype.getToken = function () {
        return localStorage.getItem(CURRENT_USER);
    };
    AuthenticationService.prototype.isAuthenticated = function () {
        // get the token
        var token = this.getToken();
        // return a boolean reflecting
        // whether or not the token is expired
        return !this.jwtHelper.isTokenExpired(token);
    };
    AuthenticationService.prototype.logout = function () {
        // remove user from local storage to log user out
        localStorage.removeItem(CURRENT_USER);
    };
    AuthenticationService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], AuthenticationService);
    return AuthenticationService;
}());



/***/ }),

/***/ "./src/app/services/io-table.service.ts":
/*!**********************************************!*\
  !*** ./src/app/services/io-table.service.ts ***!
  \**********************************************/
/*! exports provided: IoTableService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IoTableService", function() { return IoTableService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var IoTableService = /** @class */ (function () {
    function IoTableService(http) {
        this.http = http;
        // URL to web api
        this.ioMapUrl = 'api/ioMap';
        this.ioTable = null;
        this.items = [];
    }
    IoTableService.prototype.getItems = function () {
        return this.items;
    };
    IoTableService.prototype.getIoTable = function (projectId) {
        var _this = this;
        var params = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]().set('project', projectId.toString());
        return this.http.get(this.ioMapUrl, { params: params, headers: httpOptions.headers })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["tap"])(function (ioTable) {
            _this.ioTable = ioTable;
            _this.items = _this.ioTable.map(function (ioMap) { return ioMap.IOName; });
        }));
    };
    IoTableService.prototype.addIOMap = function (ioMap) {
        var _this = this;
        return this.http.post(this.ioMapUrl, ioMap, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["tap"])(function (ret) {
            _this.ioTable.push(ret);
            _this.items.push(ret.IOName);
        }));
    };
    IoTableService.prototype.deleteIOMap = function (id) {
        var _this = this;
        return this.http.delete(this.ioMapUrl + '/' + id.toString(), { observe: 'response', headers: httpOptions.headers })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["tap"])(function (response) {
            _this.ioTable.splice(_this.ioTable.findIndex(function (val) { return val.id === response.body.id; }), 1);
            _this.items.splice(_this.items.findIndex(function (item) { return item === response.body.IOName; }), 1);
        }));
    };
    IoTableService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], IoTableService);
    return IoTableService;
}());



/***/ }),

/***/ "./src/app/services/project.service.ts":
/*!*********************************************!*\
  !*** ./src/app/services/project.service.ts ***!
  \*********************************************/
/*! exports provided: ProjectService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectService", function() { return ProjectService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _requirement_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./requirement.service */ "./src/app/services/requirement.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var ProjectService = /** @class */ (function () {
    function ProjectService(http, reqService) {
        this.http = http;
        this.reqService = reqService;
        // URL to web api
        this.projectsUrl = 'api/projects';
        this.projects = null;
    }
    /** GET projects */
    ProjectService.prototype.getProjects = function () {
        var _this = this;
        return this.http.get(this.projectsUrl, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('getProjects', null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (projects) {
            _this.projects = projects;
        }));
    };
    /** GET project */
    ProjectService.prototype.getProject = function (id) {
        var _this = this;
        if (this.projects !== null) {
            var project = this.projects.find(function (prj) { return prj.id === id; });
            if (project) {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(project);
            }
        }
        return this.http.get(this.projectsUrl + '/' + id, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (project) { return _this.projects === null ? _this.projects = [project] : _this.projects.push(project); }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('getProjects ' + id, null)));
    };
    /** POST new project */
    ProjectService.prototype.createProject = function (project) {
        var _this = this;
        /**
         * 响应体可能并不包含你需要的全部信息。有时候服务器会返回一个特殊的响应头或状态码，以标记出特定的条件，因此读取它们可能是必要的。
         * 要这样做，你就要通过 observe 选项来告诉 HttpClient，你想要完整的响应信息，而不是只有响应体：
         */
        return this.http.post(this.projectsUrl, project, {
            headers: httpOptions.headers,
            observe: 'response'
        })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('createProject', null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (response) {
            _this.projects.push(response.body);
        }));
    };
    /** DELETE project */
    ProjectService.prototype.deleteProject = function (project) {
        var _this = this;
        var id = typeof project === 'number' ? project : project.id;
        var url = this.projectsUrl + "/" + id;
        return this.http.delete(url, httpOptions).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('deleteProject ' + id, null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (proj) {
            _this.reqService.getRequirements(id).subscribe(function (requirements) {
                requirements.forEach(function (req) { return _this.reqService.deleteRequirement(req.id).subscribe(); });
            });
            _this.projects.filter(function (val) {
                return proj.id !== val.id;
            });
        }));
    };
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    ProjectService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(operation + ': ' + error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(result);
        };
    };
    ProjectService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"], _requirement_service__WEBPACK_IMPORTED_MODULE_4__["RequirementService"]])
    ], ProjectService);
    return ProjectService;
}());



/***/ }),

/***/ "./src/app/services/requirement.service.ts":
/*!*************************************************!*\
  !*** ./src/app/services/requirement.service.ts ***!
  \*************************************************/
/*! exports provided: RequirementService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RequirementService", function() { return RequirementService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var RequirementService = /** @class */ (function () {
    function RequirementService(http) {
        this.http = http;
        this.requirementsUrl = 'api/requirements';
        this.reqFileUrl = 'api/requirements/file';
        this.reqTranslateUrl = 'api/requirements/translate';
        this.items = new Map();
        this.wordsList = [
            'Globally',
            'After',
            'When',
            'until',
            'is',
            'true',
            'false',
            'exists',
            'delayL',
            'delayR',
            'delayRE',
            'and',
            'or',
            'not',
            '='
        ];
    }
    RequirementService.prototype.ObjectFilter = function (req) {
        var _this = this;
        return req.slice(0, req.length - 1).split(/\(|\)| |,/)
            .filter(function (value) {
            return value.length > 0 && _this.wordsList.indexOf(value) === -1 && !/^\d+$/.test(value);
        });
    };
    RequirementService.prototype.getRequirements = function (projectId) {
        var _this = this;
        var params = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"]().set('project', projectId.toString());
        return this.http.get(this.requirementsUrl, { params: params, headers: httpOptions.headers })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('getRequirements', null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (requirements) {
            _this.requirements = requirements;
            _this.requirements.forEach(function (req) {
                _this.ObjectFilter(req.text).forEach(function (value) {
                    return _this.items.has(req.project) ?
                        _this.items.get(req.project).add(value) :
                        _this.items.set(req.project, new Set([value]));
                });
            });
        }));
    };
    RequirementService.prototype.getRequirement = function (id) {
        var _this = this;
        if (this.requirements !== null) {
            var req = this.requirements.find(function (val) { return val.id === id; });
            if (req !== null) {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(req);
            }
        }
        return this.http.get(this.requirementsUrl + '/' + id, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('getRequirement ' + id, null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (req) {
            _this.requirements.push(req);
            _this.ObjectFilter(req.text).forEach(function (value) {
                return _this.items.has(req.project) ?
                    _this.items.get(req.project).add(value) :
                    _this.items.set(req.project, new Set([value]));
            });
        }));
    };
    RequirementService.prototype.createRequirement = function (req) {
        var _this = this;
        return this.http.post(this.requirementsUrl, req, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('createRequirement', null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (requirement) {
            _this.requirements.push(requirement);
            _this.ObjectFilter(requirement.text).forEach(function (value) {
                return _this.items.has(requirement.project) ?
                    _this.items.get(requirement.project).add(value) :
                    _this.items.set(requirement.project, new Set([value]));
            });
        }));
    };
    RequirementService.prototype.updateRequirement = function (req) {
        var _this = this;
        return this.http.put(this.requirementsUrl, req, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('updateRequirement ' + req.id, null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (requirement) {
            _this.requirements.splice(_this.requirements.findIndex(function (val) { return val.id === requirement.id; }), 1, requirement);
            _this.ObjectFilter(requirement.text).forEach(function (value) {
                return _this.items.has(requirement.project) ?
                    _this.items.get(requirement.project).add(value) :
                    _this.items.set(requirement.project, new Set([value]));
            });
        }));
    };
    RequirementService.prototype.deleteRequirement = function (id) {
        var _this = this;
        return this.http.delete(this.requirementsUrl + '/' + id, { observe: 'response', headers: httpOptions.headers })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('deleteRequirement ' + id, null)), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["tap"])(function (requirement) {
            _this.requirements.splice(_this.requirements.findIndex(function (val) { return val.id === requirement.body.id; }), 1);
            _this.items = new Map();
            _this.requirements.forEach(function (req) {
                _this.ObjectFilter(req.text).forEach(function (value) {
                    return _this.items.has(requirement.project) ?
                        _this.items.get(requirement.project).add(value) :
                        _this.items.set(requirement.project, new Set([value]));
                });
            });
        }));
    };
    RequirementService.prototype.uploadFile = function (file, projectId) {
        var formData = new FormData();
        formData.append('file', file, file.name);
        formData.append('pId', projectId.toString());
        return this.http.post(this.reqFileUrl, formData);
    };
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    RequirementService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(operation + ': ' + error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(result);
        };
    };
    RequirementService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], RequirementService);
    return RequirementService;
}());



/***/ }),

/***/ "./src/app/services/task.service.ts":
/*!******************************************!*\
  !*** ./src/app/services/task.service.ts ***!
  \******************************************/
/*! exports provided: TaskService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TaskService", function() { return TaskService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var TaskService = /** @class */ (function () {
    function TaskService(http) {
        this.http = http;
        this.taskUrl = 'api/task';
        this.finishedTaskUrl = 'api/task/finished';
    }
    TaskService.prototype.getTask = function (projectId) {
        var url = this.taskUrl + '/' + projectId;
        return this.http.get(url, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["delay"])(500), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('getTask ' + projectId, null)));
    };
    TaskService.prototype.getFinishedTask = function (projectId) {
        var url = this.finishedTaskUrl + '/' + projectId;
        return this.http.get(url, { observe: 'response', headers: httpOptions.headers })
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('getFinishedTask ' + projectId, null)));
    };
    TaskService.prototype.postTask = function (task) {
        return this.http.post(this.taskUrl, task, httpOptions)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["delay"])(500), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(this.handleError('postTask ' + task.projectId, null)));
    };
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    TaskService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            console.error(operation + ': ' + error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(result);
        };
    };
    TaskService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], TaskService);
    return TaskService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ "./src/material-module.ts":
/*!********************************!*\
  !*** ./src/material-module.ts ***!
  \********************************/
/*! exports provided: MaterialModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MaterialModule", function() { return MaterialModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/cdk/a11y */ "./node_modules/@angular/cdk/esm5/a11y.es5.js");
/* harmony import */ var _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/cdk/drag-drop */ "./node_modules/@angular/cdk/esm5/drag-drop.es5.js");
/* harmony import */ var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/cdk/portal */ "./node_modules/@angular/cdk/esm5/portal.es5.js");
/* harmony import */ var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/cdk/scrolling */ "./node_modules/@angular/cdk/esm5/scrolling.es5.js");
/* harmony import */ var _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/cdk/stepper */ "./node_modules/@angular/cdk/esm5/stepper.es5.js");
/* harmony import */ var _angular_cdk_table__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/cdk/table */ "./node_modules/@angular/cdk/esm5/table.es5.js");
/* harmony import */ var _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/cdk/tree */ "./node_modules/@angular/cdk/esm5/tree.es5.js");
/* harmony import */ var _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/autocomplete */ "./node_modules/@angular/material/esm5/autocomplete.es5.js");
/* harmony import */ var _angular_material_badge__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/badge */ "./node_modules/@angular/material/esm5/badge.es5.js");
/* harmony import */ var _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/bottom-sheet */ "./node_modules/@angular/material/esm5/bottom-sheet.es5.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/esm5/button.es5.js");
/* harmony import */ var _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/material/button-toggle */ "./node_modules/@angular/material/esm5/button-toggle.es5.js");
/* harmony import */ var _angular_material_card__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/material/card */ "./node_modules/@angular/material/esm5/card.es5.js");
/* harmony import */ var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/checkbox */ "./node_modules/@angular/material/esm5/checkbox.es5.js");
/* harmony import */ var _angular_material_chips__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/material/chips */ "./node_modules/@angular/material/esm5/chips.es5.js");
/* harmony import */ var _angular_material_stepper__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/material/stepper */ "./node_modules/@angular/material/esm5/stepper.es5.js");
/* harmony import */ var _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/material/datepicker */ "./node_modules/@angular/material/esm5/datepicker.es5.js");
/* harmony import */ var _angular_material_dialog__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/material/dialog */ "./node_modules/@angular/material/esm5/dialog.es5.js");
/* harmony import */ var _angular_material_divider__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/material/divider */ "./node_modules/@angular/material/esm5/divider.es5.js");
/* harmony import */ var _angular_material_expansion__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/material/expansion */ "./node_modules/@angular/material/esm5/expansion.es5.js");
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @angular/material/grid-list */ "./node_modules/@angular/material/esm5/grid-list.es5.js");
/* harmony import */ var _angular_material_icon__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @angular/material/icon */ "./node_modules/@angular/material/esm5/icon.es5.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/esm5/input.es5.js");
/* harmony import */ var _angular_material_list__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @angular/material/list */ "./node_modules/@angular/material/esm5/list.es5.js");
/* harmony import */ var _angular_material_menu__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! @angular/material/menu */ "./node_modules/@angular/material/esm5/menu.es5.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/esm5/core.es5.js");
/* harmony import */ var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! @angular/material/paginator */ "./node_modules/@angular/material/esm5/paginator.es5.js");
/* harmony import */ var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! @angular/material/progress-bar */ "./node_modules/@angular/material/esm5/progress-bar.es5.js");
/* harmony import */ var _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! @angular/material/progress-spinner */ "./node_modules/@angular/material/esm5/progress-spinner.es5.js");
/* harmony import */ var _angular_material_radio__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! @angular/material/radio */ "./node_modules/@angular/material/esm5/radio.es5.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/esm5/select.es5.js");
/* harmony import */ var _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! @angular/material/sidenav */ "./node_modules/@angular/material/esm5/sidenav.es5.js");
/* harmony import */ var _angular_material_slider__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! @angular/material/slider */ "./node_modules/@angular/material/esm5/slider.es5.js");
/* harmony import */ var _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! @angular/material/slide-toggle */ "./node_modules/@angular/material/esm5/slide-toggle.es5.js");
/* harmony import */ var _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! @angular/material/snack-bar */ "./node_modules/@angular/material/esm5/snack-bar.es5.js");
/* harmony import */ var _angular_material_sort__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! @angular/material/sort */ "./node_modules/@angular/material/esm5/sort.es5.js");
/* harmony import */ var _angular_material_table__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! @angular/material/table */ "./node_modules/@angular/material/esm5/table.es5.js");
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! @angular/material/tabs */ "./node_modules/@angular/material/esm5/tabs.es5.js");
/* harmony import */ var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! @angular/material/toolbar */ "./node_modules/@angular/material/esm5/toolbar.es5.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/esm5/tooltip.es5.js");
/* harmony import */ var _angular_material_tree__WEBPACK_IMPORTED_MODULE_41__ = __webpack_require__(/*! @angular/material/tree */ "./node_modules/@angular/material/esm5/tree.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};










































var MaterialModule = /** @class */ (function () {
    function MaterialModule() {
    }
    MaterialModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            exports: [
                _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["A11yModule"],
                _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_5__["CdkStepperModule"],
                _angular_cdk_table__WEBPACK_IMPORTED_MODULE_6__["CdkTableModule"],
                _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_7__["CdkTreeModule"],
                _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_2__["DragDropModule"],
                _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_8__["MatAutocompleteModule"],
                _angular_material_badge__WEBPACK_IMPORTED_MODULE_9__["MatBadgeModule"],
                _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_10__["MatBottomSheetModule"],
                _angular_material_button__WEBPACK_IMPORTED_MODULE_11__["MatButtonModule"],
                _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_12__["MatButtonToggleModule"],
                _angular_material_card__WEBPACK_IMPORTED_MODULE_13__["MatCardModule"],
                _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__["MatCheckboxModule"],
                _angular_material_chips__WEBPACK_IMPORTED_MODULE_15__["MatChipsModule"],
                _angular_material_stepper__WEBPACK_IMPORTED_MODULE_16__["MatStepperModule"],
                _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_17__["MatDatepickerModule"],
                _angular_material_dialog__WEBPACK_IMPORTED_MODULE_18__["MatDialogModule"],
                _angular_material_divider__WEBPACK_IMPORTED_MODULE_19__["MatDividerModule"],
                _angular_material_expansion__WEBPACK_IMPORTED_MODULE_20__["MatExpansionModule"],
                _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_21__["MatGridListModule"],
                _angular_material_icon__WEBPACK_IMPORTED_MODULE_22__["MatIconModule"],
                _angular_material_input__WEBPACK_IMPORTED_MODULE_23__["MatInputModule"],
                _angular_material_list__WEBPACK_IMPORTED_MODULE_24__["MatListModule"],
                _angular_material_menu__WEBPACK_IMPORTED_MODULE_25__["MatMenuModule"],
                _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatNativeDateModule"],
                _angular_material_paginator__WEBPACK_IMPORTED_MODULE_27__["MatPaginatorModule"],
                _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_28__["MatProgressBarModule"],
                _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_29__["MatProgressSpinnerModule"],
                _angular_material_radio__WEBPACK_IMPORTED_MODULE_30__["MatRadioModule"],
                _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatRippleModule"],
                _angular_material_select__WEBPACK_IMPORTED_MODULE_31__["MatSelectModule"],
                _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_32__["MatSidenavModule"],
                _angular_material_slider__WEBPACK_IMPORTED_MODULE_33__["MatSliderModule"],
                _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_34__["MatSlideToggleModule"],
                _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_35__["MatSnackBarModule"],
                _angular_material_sort__WEBPACK_IMPORTED_MODULE_36__["MatSortModule"],
                _angular_material_table__WEBPACK_IMPORTED_MODULE_37__["MatTableModule"],
                _angular_material_tabs__WEBPACK_IMPORTED_MODULE_38__["MatTabsModule"],
                _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_39__["MatToolbarModule"],
                _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_40__["MatTooltipModule"],
                _angular_material_tree__WEBPACK_IMPORTED_MODULE_41__["MatTreeModule"],
                _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_3__["PortalModule"],
                _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_4__["ScrollingModule"],
            ]
        })
    ], MaterialModule);
    return MaterialModule;
}());



/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/yaoxinyan/Public/sps2plc/sps2plc-frontend/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map