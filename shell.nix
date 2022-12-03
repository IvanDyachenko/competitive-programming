{ pkgs ? import <nixpkgs> { }, ... }:

let
  texliveCustom = pkgs.texlive.combine {
    inherit (pkgs.texlive) scheme-basic
      # Needed on top of scheme-basic
      latexmk wrapfig ulem capt-of lh metafont cyrillic babel-russian;
  };
in
pkgs.mkShell {
  name = "competitive-programming";

  buildInputs = [
    # Development
    pkgs.adoptopenjdk-hotspot-bin-16
    pkgs.sbt
    pkgs.metals
    pkgs.scala-cli

    # Documentation
    pkgs.ditaa texliveCustom
  ];

  shellHook = ''
    export JAVA_HOME="${pkgs.adoptopenjdk-hotspot-bin-16}"
  '';
}
