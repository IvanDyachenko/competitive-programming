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
    # Documentation
    pkgs.ditaa texliveCustom
  ];
}
