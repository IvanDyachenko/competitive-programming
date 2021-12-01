{ pkgs ? import <nixpkgs> { }, ... }:

pkgs.stdenv.mkDerivation rec {
  name = "development-env";
  env = pkgs.buildEnv { name = name; paths = buildInputs; };
  buildInputs =
    let
      texliveCustom = pkgs.texlive.combine {
        inherit (pkgs.texlive) scheme-basic
          # Needed on top of scheme-basic
          latexmk wrapfig ulem capt-of lh metafont cyrillic babel-russian;
      };
    in
      [
        # Development
        pkgs.metals
        pkgs.scala-cli

        # Documentation
        pkgs.ditaa texliveCustom
      ];
}
