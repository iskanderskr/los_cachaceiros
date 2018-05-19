var gulp = require('gulp');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var cleanCSS = require('gulp-clean-css');
var autoprefixer = require('gulp-autoprefixer');
var browserSync = require('browser-sync');
var sourcemaps = require('gulp-sourcemaps');
var imagemin = require('gulp-imagemin');
var cache = require('gulp-cache');

var paths = {
  src: './src/',
  dest: '../Los_cachaceiros/WebContent/',
};

var swallowError = function(error) {
  console.log(error.toString())
  this.emit('end')
}
gulp.task('browser-sync', function() {
  browserSync({
    proxy: 'localhost:8080/Los_cachaceiros',
    browser: "chrome",
    open: true,
    port: "3000",
    notify: false
  });
});
gulp.task('bs-reload', function () {
  browserSync.reload();
});
gulp.task('jsp', function(){
  return gulp.src(paths.src+'jsp/*.jsp')
    .pipe(gulp.dest(paths.dest))
    .pipe(browserSync.reload({stream:true}))
});
gulp.task('fonts', function(){
  return gulp.src(paths.src+'fonts/*.*')
    .pipe(gulp.dest(paths.dest+'fonts/'))
    .pipe(browserSync.reload({stream:true}))
});
gulp.task('css', function(){
  return gulp.src([paths.src+'scss/*.scss'])
    .pipe(sass())
    .on('error', swallowError)
    .pipe(autoprefixer())
    .pipe(cleanCSS())
    .pipe(concat('styles.css'))
    .pipe(gulp.dest(paths.dest+'css/'))
    .pipe(browserSync.reload({stream:true}))
});
gulp.task('js', function(){
  return gulp.src(paths.src+'js/*.js')
    .pipe(sourcemaps.init())
    .pipe(concat('scripts.js'))
    .pipe(sourcemaps.write())
    .pipe(gulp.dest(paths.dest+'js'))
    .pipe(browserSync.reload({stream:true}))
});
gulp.task('img', function(){
  gulp.src(paths.src+'img/*.*')
    .pipe(cache(imagemin({ optimizationLevel: 3, progressive: true, interlaced: true })))
    .pipe(gulp.dest(paths.dest+'img'));
});
gulp.task('default', [ 'jsp', 'css', 'js', 'img', 'fonts', 'browser-sync'], function(){
    gulp.watch(paths.src+"scss/*.scss", ['css']).on('change', browserSync.reload);
    gulp.watch(paths.src+"js/*.js", ['js']).on('change', browserSync.reload);
    gulp.watch(paths.src+"jsp/*.jsp", ['jsp']).on('change', browserSync.reload);
});